package visitor.mode1;

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
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.extract2txt();
        }
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.compress();
        }
    }
}
