package iterator;

import java.util.Iterator;

/**
 * @author xuxiang
 */
public class Test {
    public static void main(String[] args) {
        SnapshotArrayList<Integer> snapshotArrayList = new SnapshotArrayList<>();

        snapshotArrayList.add(1);
        snapshotArrayList.add(2);
        snapshotArrayList.add(3);

        Iterator<Integer> iterator = snapshotArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
