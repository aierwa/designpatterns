package sender;

import level.AlertLevel;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public abstract class AlertMessageSender {
    protected AlertLevel alertLevel;

    public AlertMessageSender(AlertLevel alertLevel) {
        this.alertLevel = alertLevel;
    }

    public void send(AlertLevel alertLevel, String message) {
        if (alertLevel.higherThanAndEqual(this.alertLevel)) {
            doSend(message);
        }
    }

    protected abstract void doSend(String message);
}
