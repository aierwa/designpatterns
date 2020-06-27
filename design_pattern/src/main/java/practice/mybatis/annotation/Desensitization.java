package practice.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuxiang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {
    /**
     * 脱敏规则类型
     *
     * @return DesensitizationType
     */
    DesensitizationType type();

    /**
     * 附加值, 自定义正则表达式等
     *
     * @return String[]
     */
    String[] attach() default "";
}
