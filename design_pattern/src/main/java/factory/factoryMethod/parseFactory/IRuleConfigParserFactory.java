package factory.factoryMethod.parseFactory;

import factory.factoryMethod.parser.IRuleConfigParser;

/**
 * @author xuxiang
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser getFactory();
}
