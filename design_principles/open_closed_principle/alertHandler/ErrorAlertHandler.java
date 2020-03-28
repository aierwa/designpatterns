package alertHandler;

import entity.ApiStatInfo;
import level.AlertLevel;
import notification.Notification;
import rule.AlertRule;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void handle(ApiStatInfo apiStatInfo) {
        if (alertRule.getMatchedRule(apiStatInfo.getApi()) != null &&
                apiStatInfo.getErrorCount() > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(AlertLevel.SEVERE, apiStatInfo.getApi() + " 错误数=" + apiStatInfo.getErrorCount() + "，超过最大设置值=" + alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount());
        }
    }
}
