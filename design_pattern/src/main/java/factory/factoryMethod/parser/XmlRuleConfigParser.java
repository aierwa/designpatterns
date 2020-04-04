package factory.factoryMethod.parser;

import factory.factoryMethod.RuleConfig;

/**
 * @author xuxiang
 */
public class XmlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String content) {
        return new RuleConfig();
    }
}
