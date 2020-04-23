package chainOfResponsibility.scene1;

/**
 * @author xuxiang
 */
public class PolicyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean filter(String content) {
        // filter algorithm...
        return false;
    }
}
