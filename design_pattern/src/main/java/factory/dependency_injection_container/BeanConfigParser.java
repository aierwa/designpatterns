package factory.dependency_injection_container;

import java.io.InputStream;
import java.util.List;

/**
 * @author xuxiang
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(String configContent);
    List<BeanDefinition> parse(InputStream inputStream);
}
