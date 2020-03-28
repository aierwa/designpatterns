package inversion_of_control;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class TestMain {
    public static void main(String[] args) {
        JunitApplication junitApplication = new JunitApplication();
        JunitApplication.register(new UserServiceTest());

        junitApplication.run();
    }
}
