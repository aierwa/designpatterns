package bridge;

/**
 * @author xuxiang
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    protected abstract void notify(String msg);
}
