package chainOfResponsibility.scene1;

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

    public boolean filter(String content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.filter(content)) {
                return false;
            }
        }
        return true;
    }
}
