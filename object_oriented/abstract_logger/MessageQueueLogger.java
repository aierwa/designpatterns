import java.util.Date;
import java.util.logging.Level;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 消息队列日志，发送日志到消息中间件
 */
public class MessageQueueLogger extends Logger {
    private MessageQueueClient messageQueueClient;

    public MessageQueueLogger(String name, Level minPermittedLevel, MessageQueueClient messageQueueClient) {
        super(name, minPermittedLevel);
        this.messageQueueClient = messageQueueClient;
    }

    @Override
    protected void doLog(Level level, String message) {
        messageQueueClient.send(new Date().toString() + "  " + level.getName() + ": " + message + "\r\n");
    }
}
