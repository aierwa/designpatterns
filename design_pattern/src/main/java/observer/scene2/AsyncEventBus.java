package observer.scene2;

import java.util.concurrent.Executor;

/**
 * asynchronous EventBus
 * @author xuxiang
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
