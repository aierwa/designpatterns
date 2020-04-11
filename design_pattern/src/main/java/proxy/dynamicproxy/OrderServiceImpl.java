package proxy.dynamicproxy;

/**
 * @author xuxiang
 */
public class OrderServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add order...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
