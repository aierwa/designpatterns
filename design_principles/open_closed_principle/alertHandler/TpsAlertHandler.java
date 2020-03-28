package alertHandler;

import entity.ApiStatInfo;
import level.AlertLevel;
import notification.Notification;
import rule.AlertRule;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void handle(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationSeconds();
        if (alertRule.getMatchedRule(apiStatInfo.getApi()) != null &&
                tps > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(AlertLevel.NORMAL, apiStatInfo.getApi() + " tps=" + tps + "，超过最大设置值=" + alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxTps());
        }
    }
}
