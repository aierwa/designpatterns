package iterator;

import java.util.AbstractList;
import java.util.Arrays;
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
        ensureCapacity();
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
                delTimestamps[i] = timestamp();
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

    private void ensureCapacity() {
        if (totalSize == elements.length) {
            this.elements = Arrays.copyOf(this.elements, elements.length * 2);
            this.addTimestamps = Arrays.copyOf(this.addTimestamps, elements.length * 2);
            this.delTimestamps = Arrays.copyOf(this.delTimestamps, elements.length * 2);
        }
    }

    private long timestamp() {
        long ts = System.currentTimeMillis();
        while (ts == System.currentTimeMillis()) {
        }
        return System.currentTimeMillis();
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

    public class SnapshotIterator<E> implements Iterator<E> {
        private long snapshotTimestamp;
        // cursor in source list
        private int cursorInAll;
        // left count that did not be iterated
        private int leftCount;
        private SnapshotArrayList<E> arrayList;

        public SnapshotIterator(SnapshotArrayList<E> arrayList) {
            this.snapshotTimestamp = timestamp();
            this.cursorInAll = 0;
            this.leftCount = arrayList.actualSize();
            this.arrayList = arrayList;

            // jump to the first existed element
            justNext();
        }

        @Override
        public boolean hasNext() {
            return this.leftCount > 0;
        }

        @Override
        public E next() {
            E currentItem = arrayList.get(cursorInAll);
            // move cursor 1 step
            cursorInAll++;
            // move cursor to next existed element
            justNext();
            // decrease left count 1 if when call next()
            leftCount--;
            return currentItem;
        }

        private void justNext() {
            while (cursorInAll < arrayList.totalSize()) {
                long addTimestamp = arrayList.getAddTimestamp(cursorInAll);
                long delTimestamp = arrayList.getDelTimestamp(cursorInAll);
                if (snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp) {
                    break;
                }
                cursorInAll++;
            }
        }
    }

}
