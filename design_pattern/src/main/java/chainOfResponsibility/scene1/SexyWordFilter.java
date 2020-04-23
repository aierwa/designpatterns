package chainOfResponsibility.scene1;

/**
 * @author xuxiang
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean filter(String content) {
        // filter algorithm...
        return false;
    }
}
