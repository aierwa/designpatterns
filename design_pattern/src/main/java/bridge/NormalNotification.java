package bridge;

/**
 * @author xuxiang
 */
public class NormalNotification extends Notification {
    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    protected void notify(String msg) {
        msgSender.send(msg);
    }
}
