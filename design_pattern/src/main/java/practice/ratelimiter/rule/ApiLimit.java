package practice.ratelimiter.rule;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuxiang
 */
@Data
@NoArgsConstructor
public class ApiLimit {
    // 默认时间窗口 1 s
    private static final int DEFAULT_UNIT = 1;
    private String api;
    private int limit;
    private int unit = DEFAULT_UNIT;

    public ApiLimit(String api, int limit, int unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_UNIT);
    }
}
