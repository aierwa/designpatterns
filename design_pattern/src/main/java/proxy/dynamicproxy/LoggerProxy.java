package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuxiang
 */
public class LoggerProxy {

    /**
     * create a proxy
     *
     * @param proxiedObject the proxied object
     * @return the proxy object
     */
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        ProxyHandler proxyHandler = new ProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, proxyHandler);
    }


    private class ProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public ProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long end = System.currentTimeMillis();
            System.out.println(proxiedObject.getClass().getName() + ":" + method.getName() + " cost time: " + (end - start));
            return result;
        }
    }
}
