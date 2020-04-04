package factory.factoryMethod.parseFactory;

import factory.factoryMethod.parser.IRuleConfigParser;
import factory.factoryMethod.parser.JsonRuleConfigParser;
import factory.factoryMethod.parser.XmlRuleConfigParser;

/**
 * @author xuxiang
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser getFactory() {
        return new XmlRuleConfigParser();
    }
}
