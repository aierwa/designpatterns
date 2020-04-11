package proxy.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * RPC 的调用端
 * The principle is Proxy!!!
 *
 * @author xuxiang
 */
public class RpcClient {

    /**
     * Refer the interface to remote service instance via Proxy and Socket.
     *
     * @param interfaceClass interface class
     * @param host           remote service's host
     * @param port           remote service's port
     * @param <T>            interface type
     * @return a proxy class of service
     */
    public <T> T refer(Class<T> interfaceClass, String host, int port) {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("interfaceClass is null");
        }
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class.");
        }
        if (host == null || "".equals(host)) {
            throw new IllegalArgumentException("host is null");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("invalid port: " + port);
        }

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (proxy, method, args) -> {
            // 建立一个 socket 连接
            Socket socket = new Socket(host, port);
            try {
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                try {
                    // 传方法
                    output.writeUTF(method.getName());
                    // 传参数类型
                    output.writeObject(method.getParameterTypes());
                    // 传参数
                    output.writeObject(args);
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                    try {
                        Object result = input.readObject();
                        // 如果是异常就抛出去
                        if (result instanceof Throwable) {
                            throw (Throwable) result;
                        }
                        return result;
                    } finally {
                        input.close();
                    }
                } finally {
                    output.close();
                }
            } finally {
                socket.close();
            }
        });
    }
}
