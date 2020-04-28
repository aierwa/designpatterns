package visitor.mode2;

/**
 * @author xuxiang
 * 2020/4/28
 */
public interface Visitor {
    void visit(PdfFile pdfFile);
    void visit(WordFile wordFile);
}
