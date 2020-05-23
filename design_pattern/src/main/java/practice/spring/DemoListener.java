package practice.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Define a Spring listener bind with DemoEvent.
 *
 * @author xuxiang
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("Received DemoEvent's message: " + demoEvent.getMessage());
    }
}
