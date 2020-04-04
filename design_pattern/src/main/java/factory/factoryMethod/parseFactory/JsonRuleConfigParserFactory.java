package factory.factoryMethod.parseFactory;

import factory.factoryMethod.parser.IRuleConfigParser;
import factory.factoryMethod.parser.JsonRuleConfigParser;

/**
 * @author xuxiang
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser getFactory() {
        return new JsonRuleConfigParser();
    }
}
