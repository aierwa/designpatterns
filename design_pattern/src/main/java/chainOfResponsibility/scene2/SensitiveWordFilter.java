package chainOfResponsibility.scene2;

/**
 * @author xuxiang
 */
public interface SensitiveWordFilter {
    /**
     * filter sensitive words
     *
     * @param content input content
     * @return filtered content
     */
    String filter(String content);
}
