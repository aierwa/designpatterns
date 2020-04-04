package factory.simple;

import factory.simple.parser.IRuleConfigParser;
import factory.simple.parser.JsonRuleConfigParser;
import factory.simple.parser.XmlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiang
 */
public class ConfigParserFactory {

    /**
     * just if else
     * @param fileExtension
     * @return
     */
//    public static IRuleConfigParser create(String fileExtension) {
//        if ("json".equalsIgnoreCase(fileExtension)) {
//            return new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(fileExtension)) {
//            return new XmlRuleConfigParser();
//        } else {
//            throw new IllegalArgumentException("File extension not supported: " + fileExtension);
//        }
//    }


    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
    }

    /**
     * The combination of factory and singleton.
     * @param fileExtension
     * @return
     */
    public static IRuleConfigParser create(String fileExtension) {
        IRuleConfigParser configParser = null;
        if (fileExtension != null && !"".equals(fileExtension)) {
            configParser = cachedParsers.get(fileExtension.toLowerCase());
        }
        if (configParser == null) {
            throw new IllegalArgumentException("File extension not supported: " + fileExtension);
        }
        return configParser;
    }

}
