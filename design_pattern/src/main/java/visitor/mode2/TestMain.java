package visitor.mode2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 * 2020/4/28
 */
public class TestMain {
    public static void main(String[] args) {
        List<ResourceFile> resourceFileList = new ArrayList<>();
        resourceFileList.add(new PdfFile("aa.pdf"));
        resourceFileList.add(new WordFile("aa.doc"));

        Visitor extractor = new Extractor();
        Visitor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.accept(extractor);
        }
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.accept(compressor);
        }
    }
}
