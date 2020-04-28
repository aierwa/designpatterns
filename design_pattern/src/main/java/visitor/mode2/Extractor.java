package visitor.mode2;

/**
 * @author xuxiang
 * 2020/4/28
 */
public class Extractor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("extract pdf to txt.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("extract word to txt.");
    }
}
