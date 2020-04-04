package factory.simple;

import factory.simple.parser.IRuleConfigParser;

/**
 * @author xuxiang
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String extension = getExtension(ruleConfigFilePath);

        IRuleConfigParser ruleConfigParser = ConfigParserFactory.create(extension);

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
