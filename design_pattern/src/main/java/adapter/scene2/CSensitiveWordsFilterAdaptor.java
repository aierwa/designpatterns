package adapter.scene2;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private CSensitiveWordsFilter cSensitiveWordsFilter;

    public String filter(String text) {
        return cSensitiveWordsFilter.filter(text, "***");
    }
}
