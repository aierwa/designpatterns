package composite.scene1;

/**
 * It represents a node
 *
 * @author xuxiang
 * 2020/4/14
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    /**
     * count the number of files in this node.
     *
     * @return number
     */
    public abstract int countNumOfFiles();

    /**
     * count the size of files in this node.
     *
     * @return size
     */
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
