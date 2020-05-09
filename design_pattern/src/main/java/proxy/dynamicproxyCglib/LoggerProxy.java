package proxy.dynamicproxyCglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Using CGLib to proxy
 * @author xuxiang
 */
public class LoggerProxy implements MethodInterceptor {
    /**
     * create a proxy
     *
     * @param proxiedClass the proxied object
     * @return the proxy object
     */
    public Object createProxy(Class proxiedClass) {
        Enhancer enhancer = new Enhancer();
        // set super class
        enhancer.setSuperclass(proxiedClass);
        enhancer.setCallback(this);
        // 通过字节码技术创建子类实例
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println(o.getClass().getName() + ":" + method.getName() + " cost time: " + (end - start));
        return result;
    }

}
