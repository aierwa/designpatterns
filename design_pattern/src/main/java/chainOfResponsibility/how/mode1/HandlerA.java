package chainOfResponsibility.how.mode1;

/**
 * @author xuxiang
 */
public class HandlerA extends Handler {
    @Override
    protected boolean doHandle() {
        // some handler logic...
        return false;
    }
}
