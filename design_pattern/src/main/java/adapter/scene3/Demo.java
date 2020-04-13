package adapter.scene3;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class Demo {
    private IA a;

    public Demo(IA a) {
        this.a = a;
    }


    public static void main(String[] args) {
        // before adaptor, we use A
        Demo demo = new Demo(new A());

        // after adaptor, we can totally use B
        Demo demoB = new Demo(new BAdaptor(new B()));
    }
}
