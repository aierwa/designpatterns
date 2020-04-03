package api_statistics_framework.version_2.reporter;

import api_statistics_framework.version_2.aggregator.Aggregator;
import api_statistics_framework.version_2.entity.ApiInfo;
import api_statistics_framework.version_2.entity.ApiStat;
import api_statistics_framework.version_2.storage.MetricsStorage;
import api_statistics_framework.version_2.view.StatView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatView statView;

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView statView) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statView = statView;
    }

    public void startRepeatableReport(long periodSeconds, long durationSeconds) {
        executor.scheduleAtFixedRate(() -> {
            long endTimeMillis = System.currentTimeMillis();
            long startTimeMillis = endTimeMillis - durationSeconds * 1000;

            Map<String, List<ApiInfo>> apiInfos = metricsStorage.getApiInfos(startTimeMillis, endTimeMillis);

            statView.output(aggregator.aggregate(apiInfos, durationSeconds * 1000), startTimeMillis, endTimeMillis);

        }, 0, periodSeconds, TimeUnit.SECONDS);
    }
}
