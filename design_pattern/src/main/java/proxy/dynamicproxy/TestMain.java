package proxy.dynamicproxy;

/**
 * @author xuxiang
 */
public class TestMain {
    public static void main(String[] args) {
        LoggerProxy loggerProxy = new LoggerProxy();

        UserService userService = (UserService) loggerProxy.createProxy(new UserServiceImpl());

        userService.addUser();

        // 这里必须用接口才行
//        OrderServiceImpl orderService = (OrderServiceImpl) loggerProxy.createProxy(new OrderServiceImpl());
//        orderService.addUser();
    }
}
