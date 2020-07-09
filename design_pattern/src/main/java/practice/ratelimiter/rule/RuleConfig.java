package practice.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuxiang
 */
@NoArgsConstructor
@AllArgsConstructor
public class RuleConfig {
    private List<AppRuleConfig> ratelimit;

    private ConcurrentHashMap<String, ApiLimit> limitsMap = new ConcurrentHashMap<>();

    public void init() {
        for (AppRuleConfig appRuleConfig : ratelimit) {
            for (ApiLimit limit : appRuleConfig.getLimits()) {
                limitsMap.put(appRuleConfig.getAppId() + ":" + limit.getApi(), limit);
            }
        }
    }

    /**
     * 根据 appId 和 url 查找限流规则
     *
     * @param appId appId
     * @param url   url
     * @return ApiLimit
     */
    public ApiLimit getLimit(String appId, String url) {
        return limitsMap.get(appId + ":" + url);
    }

    public void setRatelimit(List<AppRuleConfig> ratelimit) {
        this.ratelimit = ratelimit;
    }
}
