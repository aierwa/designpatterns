package notification;

import level.AlertLevel;
import sender.AlertMessageSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class Notification {
    private List<AlertMessageSender> alertMessageSenders = new ArrayList<>();

    public Notification(List<AlertMessageSender> alertMessageSenders) {
        this.alertMessageSenders = alertMessageSenders;
    }

    public Notification() {
    }

    public void addAlertMessageSender(AlertMessageSender alertMessageSender) {
        alertMessageSenders.add(alertMessageSender);
    }


    public void notify(AlertLevel alertLevel, String message) {
        for (AlertMessageSender alertMessageSender : alertMessageSenders) {
            alertMessageSender.send(alertLevel, message);
        }
    }
}
