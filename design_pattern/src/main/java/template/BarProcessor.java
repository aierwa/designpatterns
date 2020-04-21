package template;

/**
 * @author xuxiang
 * 2020/4/21
 */
public class BarProcessor extends AbstractProcessor {
    protected void preProcess() {
        System.out.println("hello bar");
    }

    protected void afterProcess() {
        System.out.println("bye bar");
    }
}
