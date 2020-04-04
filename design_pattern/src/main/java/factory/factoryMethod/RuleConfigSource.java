package factory.factoryMethod;

import factory.factoryMethod.parseFactory.IRuleConfigParserFactory;
import factory.factoryMethod.parseFactory.RuleConfigParserFactoryMap;
import factory.factoryMethod.parser.IRuleConfigParser;

/**
 * @author xuxiang
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String extension = getExtension(ruleConfigFilePath);

        IRuleConfigParserFactory factory = RuleConfigParserFactoryMap.getRuleConfigParseFactory(extension);
        IRuleConfigParser ruleConfigParser = factory.getFactory();

        String content = "";
        return ruleConfigParser.parse(content);
    }

    /**
     * get extension of file
     * @param filePath
     * @return
     */
    private String getExtension(String filePath) {
        return null;
    }
}
