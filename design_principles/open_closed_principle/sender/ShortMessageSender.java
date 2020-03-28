package sender;

import level.AlertLevel;

import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class ShortMessageSender extends AlertMessageSender {
    private List<String> phoneNumberList;

    public ShortMessageSender(AlertLevel alertLevel, List<String> phoneNumberList) {
        super(alertLevel);
        this.phoneNumberList = phoneNumberList;
    }

    @Override
    protected void doSend(String message) {
        // 发送短信
        for (String s : phoneNumberList) {
            System.out.println("发送报警短信至：" + s + "，message=" + message);
        }
    }
}
