package proxy.dynamicproxyCglib;


/**
 * @author xuxiang
 */
public class TestMain {
    public static void main(String[] args) {
        LoggerProxy loggerProxy = new LoggerProxy();

        UserService userService = (UserService) loggerProxy.createProxy(UserServiceImpl.class);

        userService.addUser();

        // 这里可以不用接口，用类
        OrderServiceImpl orderService = (OrderServiceImpl) loggerProxy.createProxy(OrderServiceImpl.class);
        orderService.addOrder();
    }
}
