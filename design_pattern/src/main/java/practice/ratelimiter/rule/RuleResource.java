package practice.ratelimiter.rule;

/**
 * 将规则来源抽象为接口，方便扩展，如 yaml，json，数据库等等
 *
 * @author xuxiang
 */
public interface RuleResource {
    RuleConfig load();
}
