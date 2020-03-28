package inversion_of_control;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    protected abstract boolean doTest();
}
