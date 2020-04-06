package factory.dependency_injection_container;

/**
 * @author xuxiang
 */
public class BeanCreateFailException extends RuntimeException {
    public BeanCreateFailException(String message) {
        super(message);
    }

    public BeanCreateFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
