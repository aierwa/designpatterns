package chainOfResponsibility.how.mode1;

/**
 * @author xuxiang
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handler() {
        boolean handled = doHandle();

        // if not handled, let next handler deal continue.
        if (!handled && successor != null) {
            successor.handler();
        }
    }

    /**
     * do handle logic
     *
     * @return true if handle over
     */
    protected abstract boolean doHandle();
}
