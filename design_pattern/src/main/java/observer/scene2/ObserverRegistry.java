package observer.scene2;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * save observerActions with method's param type
 *
 * @author xuxiang
 */
public class ObserverRegistry {
    // CopyOnWriteArraySet will create a new set when write new elements, so that don't affect the read.
    // CopyOnWriteArraySet will lock when write, so that to avoid conflict between writes.
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Preconditions.checkNotNull(observer, "object for registry is null.");
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);

        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();

            CopyOnWriteArraySet<ObserverAction> registeredActions = registry.get(eventType);
            if (registeredActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredActions = registry.get(eventType);
            }

            registeredActions.addAll(eventActions);
        }
    }

    /**
     * get matched observer actions by class type of event
     * it matches also if the class type of event is a subclass type. (class.isAssignableFrom())
     *
     * @param event event object
     * @return
     */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedActions = new ArrayList<>();
        Class<?> eventType = event.getClass();

        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            if (eventType.isAssignableFrom(entry.getKey())) {
                matchedActions.addAll(entry.getValue());
            }
        }

        return matchedActions;
    }

    /**
     * find all observer actions of object by finding method annotated by @Subscribe
     *
     * @param object
     * @return
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object object) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();

                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);

                Class<?> eventType = parameterTypes[0];
                observerActions.putIfAbsent(eventType, new ArrayList<>());
                observerActions.get(eventType).add(new ObserverAction(object, method));
            }
        }

        return observerActions;
    }

}
