package practice.mybatis.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;
import practice.mybatis.annotation.Desensitization;
import practice.mybatis.annotation.DesensitizationType;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * @author xuxiang
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
@Component
public class DesensitizationInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object returnValue = invocation.proceed();
        if (returnValue == null) {
            return null;
        }
        if (returnValue instanceof List<?>) {
            returnValue = desensitize((List<?>) returnValue);
        }

        return returnValue;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息：" + properties);
    }


    /**
     * 脱敏操作
     *
     * @param list from mybatis result set
     * @return list after desensitization
     */
    private List<?> desensitize(List<?> list) {
        Class clazz = null;
        Field[] fields = null;
        if (list == null || list.isEmpty()) {
            return list;
        }
        for (Object item : list) {
            // 每个 item 都是一个类型
            if (clazz == null) {
                clazz = item.getClass();
                fields = clazz.getDeclaredFields();
            }
            if (fields.length == 0) {
                return list;
            }

            for (Field field : fields) {
                Desensitization annotation = field.getAnnotation(Desensitization.class);
                if (annotation == null) {
                    continue;
                }
                field.setAccessible(true);
                // 成员变量值
                String value = null;
                try {
                    value = field.get(item) == null ? null : field.get(item).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    continue;
                }

                DesensitizationType desensitizationType = annotation.type();
                String[] regular;
                if (desensitizationType == DesensitizationType.CUSTOM) {
                    // 自定义的话就从 attach 取值
                    regular = annotation.attach();
                } else {
                    regular = desensitizationType.getRegular();
                }
                if (regular.length != 2) {
                    continue;
                }

                // 根据正则进行替换
                value = value.replaceAll(regular[0], regular[1]);

                try {
                    field.set(item, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        return list;
    }
}
