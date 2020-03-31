package refactoring.idGenerator.after;

import refactoring.idGenerator.after.inter.LogTraceIdGenerator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * This class can generate an random id formatted by hostname-timestamp-randomString,
 * egg 103-1577456311467-3nR3Do45
 * This id is not exactly unique in concurrent.
 *
 * @author xuxiang
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final String ALL_ALPHANUMERIC_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String HOST_NAME;
//    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    static {
        HOST_NAME = getLastFieldOfHostname();
    }

    /**
     * Generate an random id.
     *
     * @return an random id.
     */
    public String generate() {
        String id = "";
        String randomStr = generateRandomAlphanumeric(8);
        id = String.format("%s-%d-%s", HOST_NAME, System.currentTimeMillis(), randomStr);
        return id;
    }

    /**
     * Get the last field of hostname splitted by delimiter '.'.
     *
     * @return The last field of hostname. Returns 'Unknown' if catches an UnknownHostException.
     */
    private static String getLastFieldOfHostname() {
        String hostName = "Unknown";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }

    /**
     * Generate an random alphanumeric which only contains
     * digits, uppercase letters and lower letters.
     *
     * @param length the length of returned random alphanumeric
     * @return An random alphanumeric
     */
    private String generateRandomAlphanumeric(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ALL_ALPHANUMERIC_STR.charAt(random.nextInt(ALL_ALPHANUMERIC_STR.length())));
        }
        return stringBuilder.toString();
    }
}
