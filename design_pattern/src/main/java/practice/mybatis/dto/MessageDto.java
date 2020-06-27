package practice.mybatis.dto;

import practice.mybatis.annotation.Desensitization;
import practice.mybatis.annotation.DesensitizationType;

/**
 * @author xuxiang
 */
public class MessageDto {
    @Desensitization(type = DesensitizationType.HIDE_MIDDLE)
    private String code;
    private Integer type;
    @Desensitization(type = DesensitizationType.CUSTOM, attach = {"(.{3}).*", "$1****"})
    private String value;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "code='" + code + '\'' +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
