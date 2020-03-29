package api_statistics_framework.version_1.reporter;

import api_statistics_framework.version_1.entity.ApiStat;
import api_statistics_framework.version_1.storage.MetricsStorage;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class ConsoleReporter extends BaseReporter {
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public ConsoleReporter(MetricsStorage metricsStorage) {
        super(metricsStorage);
    }

    public void startRepeatableReport(long periodSeconds, long durationSeconds) {
        executor.scheduleAtFixedRate(() -> {
            // 取数据
            Map<String, ApiStat> statMap = getApiStat(System.currentTimeMillis(), durationSeconds);

            // 输出到终端
            System.out.println("Time Span [" + (System.currentTimeMillis() - durationSeconds * 1000) + " - " + System.currentTimeMillis() + "]：" + statMap);
        }, 0, periodSeconds, TimeUnit.SECONDS);
    }
}
