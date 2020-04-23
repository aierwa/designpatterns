package strategy.filesorter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class Sorter {
    private static final long GB = 1024 * 1024 * 1024;
    private static final List<AlgRange> algRanges = new ArrayList<>();

    static {
        algRanges.add(new AlgRange(0, 6 * GB, new QuickSort()));
        algRanges.add(new AlgRange(6 * GB, 10 * GB, new ExternalSort()));
        algRanges.add(new AlgRange(10 * GB, 100 * GB, new ConcurrentExternalSort()));
        algRanges.add(new AlgRange(100 * GB, Long.MAX_VALUE, new MapReduceSort()));
    }

    public static void main(String[] args) {
        String filePath = args[0];
        File file = new File(filePath);
        long fileSize = file.length();

        SortAlg sortAlg = null;

        // using list for loop to remove the if-else structure
        for (AlgRange algRange : algRanges) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getSortAlg();
                break;
            }
        }

        sortAlg.sort(filePath);
    }
}
