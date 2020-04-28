package visitor.mode2;

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

    /**
     * link resource object to visitor
     *
     * @param visitor visitor
     */
    public abstract void accept(Visitor visitor);

}
