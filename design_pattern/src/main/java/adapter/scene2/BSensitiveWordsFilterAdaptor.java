package adapter.scene2;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private BSensitiveWordsFilter bSensitiveWordsFilter;

    public String filter(String text) {
        return bSensitiveWordsFilter.filter(text);
    }

}
