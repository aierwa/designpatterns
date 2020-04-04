package factory.factoryMethod.parser;

import factory.factoryMethod.RuleConfig;

/**
 * @author xuxiang
 */
public interface IRuleConfigParser {
    RuleConfig parse(String content);
}
