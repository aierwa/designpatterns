package bridge;

import java.util.List;

/**
 * @author xuxiang
 */
public class EmailMsgSender implements MsgSender {
    private List<String> address;

    public EmailMsgSender(List<String> address) {
        this.address = address;
    }

    @Override
    public void send(String msg) {
        // send to address.
    }
}
