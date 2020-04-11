package proxy.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * RPC 的暴露服务
 *
 * @author xuxiang
 */
public class RpcServer {

    /**
     * Export a service instance and continuous listen the requests.
     *
     * @param service the service instance
     * @param port    export port
     * @throws Exception e
     */
    public void export(Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("service instance == null");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("invalid port");
        }

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            // 等待一个连接
            final Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    // 将 socket 流转为本地 Object 流
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        // 读取第一个内容，为 method （和 RpcClient 端约定）
                        String methodName = input.readUTF();
                        Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                        Object[] args = (Object[]) input.readObject();

                        // 通过反射来调用
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(service, args);
                        output.writeObject(result);

                    } catch (Throwable t) {
                        output.writeObject(t);
                    } finally {
                        input.close();
                        output.close();
                        socket.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
