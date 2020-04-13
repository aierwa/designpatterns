package adapter.scene2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<ISensitiveWordsFilter>();

    public void addFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filter(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
}
