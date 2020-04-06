package factory.dependency_injection_container;

/**
 * Dependency Injection Container
 * @author xuxiang
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
