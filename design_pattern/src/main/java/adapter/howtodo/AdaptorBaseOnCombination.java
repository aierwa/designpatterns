package adapter.howtodo;

/**
 * An adaptor based on combination
 *
 * @author xuxiang
 */
public class AdaptorBaseOnCombination implements ITarget {
    private Adaptee adaptee;

    public AdaptorBaseOnCombination(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        // also we can change the args, re-implement the logic.
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
