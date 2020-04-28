package visitor.mode1;

/**
 * @author xuxiang
 * 2020/4/28
 */
public class WordFile extends ResourceFile {
    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2txt() {
        System.out.println("extract word to txt.");
    }

    @Override
    public void compress() {
        System.out.println("compress word.");
    }
}
