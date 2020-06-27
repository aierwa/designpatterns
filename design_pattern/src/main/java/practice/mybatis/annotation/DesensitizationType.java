package practice.mybatis.annotation;

/**
 * @author xuxiang
 */
public enum DesensitizationType {
    PHONE("phone", "11位手机号", "^(\\d{3})\\d{4}(\\d{3})", "$1****$2"),
    HIDE_MIDDLE("hideMiddle","隐藏中间","(?<=.{1}).*(?=.{1})","*"),
    CUSTOM("custom","自定义",""),
    ;

    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
    /**
     * 规则
     */
    private String[] regular;

    DesensitizationType(String type, String description, String... regular) {
        this.type = type;
        this.description = description;
        this.regular = regular;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String[] getRegular() {
        return regular;
    }
}
