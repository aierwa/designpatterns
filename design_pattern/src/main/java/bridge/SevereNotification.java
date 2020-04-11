package bridge;

/**
 * @author xuxiang
 */
public class SevereNotification extends Notification {
    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    protected void notify(String msg) {
        msgSender.send(msg);
    }
}
