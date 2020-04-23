package strategy.filesorter;

/**
 * @author xuxiang
 */
public class AlgRange {
    private long start;
    private long end;

    private SortAlg sortAlg;

    public SortAlg getSortAlg() {
        return sortAlg;
    }

    public AlgRange(long start, long end, SortAlg sortAlg) {
        this.start = start;
        this.end = end;
        this.sortAlg = sortAlg;
    }

    public boolean inRange(long size) {
        return size >= start && size < end;
    }
}
