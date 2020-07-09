package practice.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xuxiang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRuleConfig {
    private String appId;
    private List<ApiLimit> limits;
}
