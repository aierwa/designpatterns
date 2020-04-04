package factory.factoryMethod.parseFactory;


import java.util.HashMap;
import java.util.Map;

/**
 * The factory of factory classes.
 * @author xuxiang
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getRuleConfigParseFactory(String fileExtension) {
        IRuleConfigParserFactory configParserFactory = null;
        if (fileExtension != null && !"".equals(fileExtension)) {
            configParserFactory = cachedFactories.get(fileExtension.toLowerCase());
        }
        if (configParserFactory == null) {
            throw new IllegalArgumentException("File extension not supported: " + fileExtension);
        }
        return configParserFactory;
    }
}
