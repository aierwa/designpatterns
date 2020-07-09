package practice.ratelimiter.rule;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuxiang
 */
public class YamlRuleResource implements RuleResource {
    @Override
    public RuleConfig load() {
        RuleConfig ruleConfig;
        Yaml yaml = new Yaml();
        try (InputStream in = this.getClass().getResourceAsStream("/ratelimit-config.yml")) {
            ruleConfig = yaml.loadAs(in, RuleConfig.class);
        } catch (IOException e) {
            throw new RuntimeException("io error:" + e.getMessage());
        }
        ruleConfig.init();
        return ruleConfig;
    }
}
