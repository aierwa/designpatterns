import java.io.IOException;
import java.util.logging.Level;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        Logger logger = new FileLogger(TestMain.class.getCanonicalName(), Level.INFO, "E:\\aierwa\\temp\\testLogger.txt");
        logger.logger(Level.INFO, "this is info message");
        logger.logger(Level.SEVERE, "this is severe message");
        logger.logger(Level.CONFIG, "this is config message");

//        KafkaMessageQueueClient kafkaMessageQueueClient = new KafkaMessageQueueClient();
//        Logger messageQueueLogger = new MessageQueueLogger(TestMain.class.getName(), Level.INFO, kafkaMessageQueueClient);
//        messageQueueLogger.logger(Level.INFO, "this is info message");
    }
}
