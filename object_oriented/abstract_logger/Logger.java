import java.util.logging.Level;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 定义一个 Logger 模板
 */
public abstract class Logger {
    private String name;
    // 不用定义 enabled 字段，因为 Level 里有个级别为 Level.OFF
//    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, Level minPermittedLevel) {
        this.name = name;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void logger(Level level, String message) {
        if (level.intValue() < minPermittedLevel.intValue()) {
            return;
        }
        doLog(level, message);
    }

    protected abstract void doLog(Level level, String message);
}
