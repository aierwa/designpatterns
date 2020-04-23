package chainOfResponsibility.scene2;

/**
 * @author xuxiang
 */
public class PolicyWordFilter implements SensitiveWordFilter {
    @Override
    public String filter(String content) {
        // filter algorithm...

        return content.replaceAll("法轮功", "***");
    }
}
