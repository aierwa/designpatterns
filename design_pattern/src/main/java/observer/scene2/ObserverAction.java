package observer.scene2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xuxiang
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    /**
     * trigger the method for target
     *
     * @param event the param of method
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
