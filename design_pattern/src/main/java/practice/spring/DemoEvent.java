package practice.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Define an Spring event
 *
 * @author xuxiang
 */
public class DemoEvent extends ApplicationEvent {
    private String message;

    public DemoEvent(String message, Object source) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
