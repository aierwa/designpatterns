package rule;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class AlertRule {
    private Map<String, ApiRule> apiRules = new HashMap<>();

    public void addApiRule(ApiRule apiRule) {
        apiRules.put(apiRule.getApi(), apiRule);
    }

    public ApiRule getMatchedRule(String api) {
        return apiRules.get(api);
    }
}
