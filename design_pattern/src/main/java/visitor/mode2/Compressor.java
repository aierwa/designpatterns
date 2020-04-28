package visitor.mode2;

/**
 * @author xuxiang
 * 2020/4/28
 */
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("compress pdf.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("compress word.");
    }
}
