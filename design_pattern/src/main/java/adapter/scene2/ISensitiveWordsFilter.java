package adapter.scene2;

/**
 * Unify all filters to this interface
 * @author xuxiang
 * 2020/4/13
 */
public interface ISensitiveWordsFilter {
    String filter(String text);
}
