package template;

/**
 * @author xuxiang
 * 2020/4/21
 */
public class FooProcessor extends AbstractProcessor {
    protected void preProcess() {
        System.out.println("hello foo");
    }

    protected void afterProcess() {
        System.out.println("bye foo");
    }
}
