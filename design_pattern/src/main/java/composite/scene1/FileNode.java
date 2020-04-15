package composite.scene1;

import java.io.File;

/**
 * @author xuxiang
 * 2020/4/14
 */
public class FileNode extends FileSystemNode {

    public FileNode(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        // file self
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        File file = new File(path);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }
}
