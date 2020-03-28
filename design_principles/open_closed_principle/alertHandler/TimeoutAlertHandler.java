package alertHandler;

import entity.ApiStatInfo;
import level.AlertLevel;
import notification.Notification;
import rule.AlertRule;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class TimeoutAlertHandler extends AlertHandler {
    public TimeoutAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void handle(ApiStatInfo apiStatInfo) {
        long timeoutTps = apiStatInfo.getTimeoutCount() / apiStatInfo.getDurationSeconds();
        if (alertRule.getMatchedRule(apiStatInfo.getApi()) != null &&
                timeoutTps > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            notification.notify(AlertLevel.SEVERE, apiStatInfo.getApi() + " 超时TPS=" + timeoutTps + "，超过最大设置值=" + alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps());
        }
    }
}
