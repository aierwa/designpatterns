package iterator;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * @author xuxiang
 */
public class SnapshotArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int actualSize;
    private int totalSize;

    private Object[] elements;
    private long[] addTimestamps;
    private long[] delTimestamps;

    public SnapshotArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        addTimestamps = new long[DEFAULT_CAPACITY];
        delTimestamps = new long[DEFAULT_CAPACITY];
        actualSize = 0;
        totalSize = 0;
    }

    @Override
    public boolean add(E e) {
        elements[totalSize] = e;
        addTimestamps[totalSize] = System.currentTimeMillis();
        delTimestamps[totalSize] = Long.MAX_VALUE;
        totalSize++;
        actualSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < totalSize; i++) {
            if (o.equals(elements[i])) {
                delTimestamps[i] = System.currentTimeMillis();
                actualSize--;
            }
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new SnapshotIterator(this);
    }

    @Override
    public int size() {
        return actualSize;
    }

    public int actualSize() {
        return actualSize;
    }

    public int totalSize() {
        return totalSize;
    }

    public long getAddTimestamp(int index) {
        if (index >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return addTimestamps[index];
    }

    public long getDelTimestamp(int index) {
        if (index >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return delTimestamps[index];
    }

//
//    private static class SnapshotIterator<E> implements Iterator<E> {
//        private long snapshotTimestamp;
//        // cursor in elements
//        private int cursorInAll;
//        // left count of not iterated elements
//        private int leftCount;
//        private SnapshotArrayList<E> list;
//
//        public SnapshotIterator(SnapshotArrayList<E> list) {
//            this.list = list;
//            snapshotTimestamp = System.currentTimeMillis();
//            cursorInAll = 0;
//            leftCount = list.actualSize();
//            justNext();
//        }
//
//        @Override
//        public boolean hasNext() {
//            return leftCount >= 0;
//        }
//
//        @Override
//        public E next() {
//            E currentItem = this.list.get(cursorInAll);
//            justNext();
//            return currentItem;
//        }
//
//
//        private void justNext(){
//            while (cursorInAll < list.totalSize()) {
//                long addTs = list.getAddTimestamp(cursorInAll);
//                long delTs = list.getDelTimestamp(cursorInAll);
//                if (snapshotTimestamp > addTs && snapshotTimestamp < delTs) {
//                    leftCount--;
//                    break;
//                }
//                cursorInAll++;
//            }
//        }
//
//    }

    public class SnapshotIterator<E> implements Iterator<E> {
        private long snapshotTimestamp;
        private int cursorInAll; // 在整个容器中的下标，而非快照中的下标
        private int leftCount; // 快照中还有几个元素未被遍历
        private SnapshotArrayList<E> arrayList;

        public SnapshotIterator(SnapshotArrayList<E> arrayList) {
            this.snapshotTimestamp = System.currentTimeMillis();
            this.cursorInAll = 0;
            this.leftCount = arrayList.actualSize() + 1;
            this.arrayList = arrayList;

            justNext(); // 先跳到这个迭代器快照的第一个元素
        }

        @Override
        public boolean hasNext() {
            return this.leftCount > 0; // 注意是>=, 而非>
        }

        @Override
        public E next() {
            E currentItem = arrayList.get(cursorInAll);
            cursorInAll++;
            justNext();
            return currentItem;
        }

        private void justNext() {
            while (cursorInAll < arrayList.totalSize()) {
                long addTimestamp = arrayList.getAddTimestamp(cursorInAll);
                long delTimestamp = arrayList.getDelTimestamp(cursorInAll);
                if (snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp) {
                    leftCount--;
                    break;
                }
                cursorInAll++;
            }
        }
    }

}
