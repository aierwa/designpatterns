package observer.scene2;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * synchronous EventBus
 *
 * @author xuxiang
 */
public class EventBus {
    private ObserverRegistry observerRegistry = new ObserverRegistry();

    private Executor executor;

    public EventBus() {
        // MoreExecutors.directExecutor() can look as a synchronized executor.
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * register an observer
     *
     * @param observer observer
     */
    public void register(Object observer) {
        observerRegistry.register(observer);
    }

    /**
     * post an event
     *
     * @param event event
     */
    public void post(Object event) {
        List<ObserverAction> observerActions = observerRegistry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(() -> observerAction.execute(event));
        }
    }

}
