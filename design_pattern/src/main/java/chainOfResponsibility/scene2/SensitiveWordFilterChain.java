package chainOfResponsibility.scene2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class SensitiveWordFilterChain {
    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        filters.add(filter);
    }

    public String filter(String content) {
        String filterContent = content;
        for (SensitiveWordFilter filter : filters) {
            filterContent = filter.filter(filterContent);
        }
        return filterContent;
    }
}
