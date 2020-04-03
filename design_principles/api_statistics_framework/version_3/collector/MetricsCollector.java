package api_statistics_framework.version_3.collector;

import api_statistics_framework.version_3.entity.ApiInfo;
import api_statistics_framework.version_3.storage.MetricsStorage;
import api_statistics_framework.version_3.storage.RedisMetricsStorage;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;  // 基于接口而非实现编程

    public MetricsCollector() {    // 依赖注入
        this(new RedisMetricsStorage());
    }

    public MetricsCollector(MetricsStorage metricsStorage) {    // 依赖注入
        this.metricsStorage = metricsStorage;
    }

    public void collect(ApiInfo apiInfo) {
        // 采集数据，进行存储
        if (apiInfo == null || apiInfo.getApi() == null || "".equals(apiInfo.getApi())) {
            return;
        }
        metricsStorage.saveApiInfo(apiInfo);
    }
}
