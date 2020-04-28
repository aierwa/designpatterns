package visitor.mode1;

/**
 * This class may be bigger more.
 *
 * @author xuxiang
 * 2020/4/28
 */
public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2txt() {
        System.out.println("extract pdf to txt.");
    }

    @Override
    public void compress() {
        System.out.println("compress pdf.");
    }
}
