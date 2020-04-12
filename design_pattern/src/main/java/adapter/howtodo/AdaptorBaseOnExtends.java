package adapter.howtodo;

/**
 * An adaptor based on extends.
 *
 * @author xuxiang
 */
public class AdaptorBaseOnExtends extends Adaptee implements ITarget {
    // now we can use iTarget.f1() to access adaptee.fa()
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }

    // we don't need to realize fc()
}
