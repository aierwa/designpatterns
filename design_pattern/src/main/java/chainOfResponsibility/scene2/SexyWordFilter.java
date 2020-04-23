package chainOfResponsibility.scene2;

/**
 * @author xuxiang
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public String filter(String content) {
        // filter algorithm...
        return content.replaceAll("黄色电影", "***");
    }
}
