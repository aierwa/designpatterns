package adapter.scene2;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private ASensitiveWordsFilter aSensitiveWordsFilter;

    public String filter(String text) {
        String maskedText = aSensitiveWordsFilter.filterSexyWords(text);
        return aSensitiveWordsFilter.filterPoliticalWords(maskedText);
    }
}
