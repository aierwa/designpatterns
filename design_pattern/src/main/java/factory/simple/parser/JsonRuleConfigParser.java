package factory.simple.parser;

import factory.simple.RuleConfig;

/**
 * @author xuxiang
 */
public class JsonRuleConfigParser implements IRuleConfigParser{
    @Override
    public RuleConfig parse(String content) {
        return new RuleConfig();
    }
}
