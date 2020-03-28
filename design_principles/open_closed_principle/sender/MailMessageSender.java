package sender;

import level.AlertLevel;

import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class MailMessageSender extends AlertMessageSender {
    private List<String> mailList;

    public MailMessageSender(AlertLevel alertLevel, List<String> mailList) {
        super(alertLevel);
        this.mailList = mailList;
    }

    @Override
    protected void doSend(String message) {
        // 发送邮件
        for (String s : mailList) {
            System.out.println("发送报警邮件至：" + s + "，message=" + message);
        }
    }
}
