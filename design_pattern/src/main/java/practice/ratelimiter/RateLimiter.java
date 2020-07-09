package practice.ratelimiter;

import practice.ratelimiter.alg.FixRateLimitAlg;
import practice.ratelimiter.alg.RateLimitAlg;
import practice.ratelimiter.rule.ApiLimit;
import practice.ratelimiter.rule.RuleConfig;
import practice.ratelimiter.rule.RuleResource;
import practice.ratelimiter.rule.YamlRuleResource;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuxiang
 */
public class RateLimiter {
    /**
     * 保存每个 appId:url 的计数器 map
     */
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RuleConfig ruleConfig;

    public RateLimiter() {
        // 将限流规则配置文件 ratelimiter-rule.yaml 中的内容读取到 RuleConfig 中
        RuleResource ruleResource = new YamlRuleResource();
        ruleConfig = ruleResource.load();
    }

    /**
     *
     * @param appId appId
     * @param url url
     * @return true 继续访问
     */
    public boolean limit(String appId, String url) {

        ApiLimit apiLimit = ruleConfig.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }

        // 获得对应的计数器
        String algKey = appId + ":" + url;
        RateLimitAlg rateLimitAlg = counters.get(algKey);
        if (rateLimitAlg == null) {
            RateLimitAlg newFixRateLimitAlg = new FixRateLimitAlg(apiLimit.getLimit(), apiLimit.getUnit());
            counters.putIfAbsent(algKey, newFixRateLimitAlg);
            rateLimitAlg = counters.get(algKey);
        }
        return rateLimitAlg.tryAcquire();

    }
}
