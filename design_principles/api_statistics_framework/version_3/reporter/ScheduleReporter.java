package api_statistics_framework.version_3.reporter;

import api_statistics_framework.version_3.aggregator.Aggregator;
import api_statistics_framework.version_3.entity.ApiInfo;
import api_statistics_framework.version_3.storage.MetricsStorage;
import api_statistics_framework.version_3.view.StatView;

import java.util.List;
import java.util.Map;

/**
 * @author xuxiang
 */
public abstract class ScheduleReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatView statView;

    public ScheduleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView statView) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statView = statView;
    }

    /**
     * Do report logic.
     * The subclass just do scheduler.
     *
     * @param startTimeMillis startTimeMillis of stat
     * @param endTimeMillis   endTimeMillis of stat
     */
    public void doReport(long startTimeMillis, long endTimeMillis) {
        // get api info data
        Map<String, List<ApiInfo>> apiInfos = metricsStorage.getApiInfos(startTimeMillis, endTimeMillis);

        // do aggregator and output
        statView.output(aggregator.aggregate(apiInfos, endTimeMillis - startTimeMillis), startTimeMillis, endTimeMillis);
    }
}
