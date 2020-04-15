package composite.scene1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 * 2020/4/14
 */
public class DirectoryNode extends FileSystemNode {
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public DirectoryNode(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int count = 0;
        for (FileSystemNode node : subNodes) {
            count += node.countNumOfFiles();
        }
        return count;
    }

    @Override
    public long countSizeOfFiles() {
        long size = 0;
        for (FileSystemNode node : subNodes) {
            size += node.countSizeOfFiles();
        }
        return size;
    }

    /**
     * add a sub node.
     *
     * @param node file or dir
     */
    public void addSubNode(FileSystemNode node) {
        subNodes.add(node);
    }

    /**
     * remove a sub node
     *
     * @param node file or dir
     */
    public void removeSubNode(FileSystemNode node) {
        int size = subNodes.size();
        for (int i = 0; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(node.getPath())) {
                subNodes.remove(i);
                break;
            }
        }
    }

}
