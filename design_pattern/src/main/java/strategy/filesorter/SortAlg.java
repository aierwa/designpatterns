package strategy.filesorter;

/**
 * sort algorithm interface
 *
 * @author xuxiang
 */
public interface SortAlg {
    /**
     * sort file by filePath input
     *
     * @param filePath file path
     */
    void sort(String filePath);
}
