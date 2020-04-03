package refactoring.api_stat_frame_v3.service;


import refactoring.api_stat_frame_v3.aggregator.Aggregator;
import refactoring.api_stat_frame_v3.entity.ApiStat;
import refactoring.api_stat_frame_v3.storage.MetricsStorage;

import java.util.Map;

/**
 * @author xuxiang
 */
public class ApiStatisticsServiceImpl implements ApiStatisticsService{

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;

    public ApiStatisticsServiceImpl(MetricsStorage metricsStorage, Aggregator aggregator) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
    }

    @Override
    public Map<String, ApiStat> getApiStat(long startTimeMillis, long endTimeMillis) {
        return aggregator.aggregate(metricsStorage.getApiInfos(startTimeMillis, endTimeMillis), endTimeMillis - startTimeMillis);
    }

    @Override
    public ApiStat getApiStat(String api, long startTimeMillis, long endTimeMillis) {
        return aggregator.doAggregate(metricsStorage.getApiInfos(api, startTimeMillis, endTimeMillis), endTimeMillis - startTimeMillis);
    }
}
