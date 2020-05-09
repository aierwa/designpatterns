package proxy.dynamicproxyCglib;

/**
 * @author xuxiang
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add user...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
