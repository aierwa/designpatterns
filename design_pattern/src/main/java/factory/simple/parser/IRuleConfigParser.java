package factory.simple.parser;

import factory.simple.RuleConfig;

/**
 * @author xuxiang
 */
public interface IRuleConfigParser {
    RuleConfig parse(String content);
}
