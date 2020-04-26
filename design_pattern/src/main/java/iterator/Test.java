package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xuxiang
 */
public class Test {
    public static void main(String[] args) {
        SnapshotArrayList<Integer> snapshotArrayList = new SnapshotArrayList<>();

        for (int i = 0; i < 15; i++) {
            snapshotArrayList.add(i);
        }
        snapshotArrayList.remove(new Integer(10));

        Iterator<Integer> iterator = snapshotArrayList.iterator();
        snapshotArrayList.remove(new Integer(1));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
