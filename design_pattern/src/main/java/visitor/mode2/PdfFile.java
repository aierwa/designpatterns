package visitor.mode2;


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
    public void accept(Visitor visitor) {
        // bind this (PdfFile class type) to visitor
        visitor.visit(this);
    }

}
