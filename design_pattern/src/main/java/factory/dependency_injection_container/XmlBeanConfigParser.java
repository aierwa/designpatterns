package factory.dependency_injection_container;

import java.io.InputStream;
import java.util.List;

/**
 * @author xuxiang
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(String configContent) {
        return null;
    }
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        return null;
    }
}
