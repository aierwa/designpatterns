package visitor.mode1;

/**
 * If more functions need to add, we must modify this class.
 *
 * @author xuxiang
 * 2020/4/28
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void extract2txt();

    public abstract void compress();
}
