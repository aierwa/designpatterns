package level;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class AlertLevel {
    public static final AlertLevel SEVERE = new AlertLevel(10); // 严重
    public static final AlertLevel URGENCY = new AlertLevel(8); // 紧急
    public static final AlertLevel NORMAL = new AlertLevel(6); // 普通
    public static final AlertLevel TRIVIAL = new AlertLevel(4); // 无关紧要

    private int code;

    public AlertLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public boolean higherThanAndEqual(AlertLevel alertLevel) {
        return getCode() >= alertLevel.getCode();
    }
}
