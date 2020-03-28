import alertHandler.AlertHandler;
import alertHandler.ErrorAlertHandler;
import alertHandler.TimeoutAlertHandler;
import alertHandler.TpsAlertHandler;
import entity.ApiStatInfo;
import level.AlertLevel;
import notification.Notification;
import rule.AlertRule;
import rule.ApiRule;
import sender.MailMessageSender;
import sender.ShortMessageSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class Alert {
    private AlertRule alertRule;
    private Notification notification;
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    private static final Alert instance = new Alert();

    public Alert() {
        init();
    }

    public void init() {
        alertRule = new AlertRule(); // 可以配置在数据库中
        alertRule.addApiRule(new ApiRule("/home", 500, 50, 5));
        alertRule.addApiRule(new ApiRule("/foo", 100, 50, 5));
        alertRule.addApiRule(new ApiRule("/bar", 100, 50, 5));

        notification = new Notification();
        notification.addAlertMessageSender(new MailMessageSender(AlertLevel.NORMAL, Arrays.asList("xx@qq.com", "yy@qq.com")));  // 达到普通就发送报警邮件
        notification.addAlertMessageSender(new ShortMessageSender(AlertLevel.SEVERE, Arrays.asList("188888888888", "13666666666")));  // 达到严重就发送报警邮件
//        notification.addAlertMessageSender(new KafkaMessageSender(AlertLevel.TRIVIAL, topic));  // 后期扩展方式

        alertHandlers.add(new ErrorAlertHandler(alertRule, notification));
        alertHandlers.add(new TpsAlertHandler(alertRule, notification));
        alertHandlers.add(new TimeoutAlertHandler(alertRule, notification));
//        alertHandlers.add(new OtherAlertHandler(alertRule, notification));
    }

    public static Alert getInstance() {
        return instance;
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.handle(apiStatInfo);
        }
    }

}
