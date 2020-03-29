package api_statistics_framework.prototype;

import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        // 每 30 秒统计一次
        metrics.startRepeatableReport(30, TimeUnit.SECONDS);
    }

    public UserVo register(UserVo userVo) {
        long start = System.currentTimeMillis();
        metrics.recordTimestamp("/register", start);

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        metrics.recordResponseTime("/register", System.currentTimeMillis() - start);
        return null;
    }

    public UserVo login(UserVo userVo) {
        long start = System.currentTimeMillis();
        metrics.recordTimestamp("/login", start);

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        metrics.recordResponseTime("/login", System.currentTimeMillis() - start);
        return null;
    }

    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.register(null);
        userController.register(null);
        userController.login(null);
        userController.login(null);

        try {
            Thread.sleep(20 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userController.register(null);
        userController.register(null);
        userController.login(null);

    }

}
