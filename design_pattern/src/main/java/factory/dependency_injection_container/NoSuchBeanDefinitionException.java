package factory.dependency_injection_container;

/**
 * @author xuxiang
 */
public class NoSuchBeanDefinitionException extends RuntimeException {
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}
