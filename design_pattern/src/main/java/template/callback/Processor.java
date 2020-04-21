package template.callback;

/**
 * @author xuxiang
 * 2020/4/21
 */
public class Processor {
    // also callback can be set or added.
    public void process(ProcessorCallback callback) {
        System.out.println("pre process");
        callback.doProcess();
        System.out.println("after process");
    }

    public static void main(String[] args) {
        new Processor().process(new ProcessorCallback() {
            public void doProcess() {
                System.out.println("foo process...");
            }
        });


        new Processor().process(new ProcessorCallback() {
            public void doProcess() {
                System.out.println("bar process...");
            }
        });
    }
}
