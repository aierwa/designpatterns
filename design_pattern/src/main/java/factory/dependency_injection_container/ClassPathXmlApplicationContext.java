package factory.dependency_injection_container;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xuxiang
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeanConfigParser beanConfigParser;
    private BeansFactory beansFactory;

    public ClassPathXmlApplicationContext(String configLocation) {
        beanConfigParser = new XmlBeanConfigParser();
        beansFactory = new BeansFactory();
        loadBeanDefinitions(configLocation);
    }

    public ClassPathXmlApplicationContext(BeanConfigParser beanConfigParser, BeansFactory beansFactory, String configLocation) {
        this.beanConfigParser = beanConfigParser;
        this.beansFactory = beansFactory;
        loadBeanDefinitions(configLocation);
    }


    private void loadBeanDefinitions(String configLocation) {
        try (InputStream in = this.getClass().getResourceAsStream("/" + configLocation)){
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            throw new RuntimeException("IO Exception", e);
        }
    }

    @Override
    public Object getBean(String beanId) {
        if (beanId == null) {
            throw new NullPointerException("beanId must not be null.");
        }
        return beansFactory.getBean(beanId);
    }
}
