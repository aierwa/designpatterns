package alertHandler;

import entity.ApiStatInfo;
import notification.Notification;
import rule.AlertRule;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public abstract class AlertHandler {
    protected AlertRule alertRule;
    protected Notification notification;

    public AlertHandler(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    public abstract void handle(ApiStatInfo apiStatInfo);
}
