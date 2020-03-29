package api_statistics_framework.version_1.reporter;

import api_statistics_framework.version_1.aggregator.Aggregator;
import api_statistics_framework.version_1.entity.ApiInfo;
import api_statistics_framework.version_1.entity.ApiStat;
import api_statistics_framework.version_1.storage.MetricsStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class BaseReporter {
    protected MetricsStorage metricsStorage;

    public BaseReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    protected Map<String, ApiStat> getApiStat(long endTime, long durationSeconds) {
        Map<String, ApiStat> statMap = new HashMap<>();
        // 取数据
        long startTime = endTime - durationSeconds * 1000;
        Map<String, List<ApiInfo>> apiInfos = metricsStorage.getApiInfos(startTime, endTime);
        for (Map.Entry<String, List<ApiInfo>> entry : apiInfos.entrySet()) {
            String api = entry.getKey();
            List<ApiInfo> apiInfoList = entry.getValue();
            statMap.put(api, Aggregator.aggregate(apiInfoList, durationSeconds * 1000));
        }
        return statMap;
    }
}
