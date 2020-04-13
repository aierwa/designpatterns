package adapter.scene3;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class BAdaptor implements IA {
    private B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    public void fa() {
        b.fb();
    }
}
