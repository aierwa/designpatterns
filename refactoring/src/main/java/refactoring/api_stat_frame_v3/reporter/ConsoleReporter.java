package refactoring.api_stat_frame_v3.reporter;


import refactoring.api_stat_frame_v3.aggregator.Aggregator;
import refactoring.api_stat_frame_v3.storage.MetricsStorage;
import refactoring.api_stat_frame_v3.storage.RedisMetricsStorage;
import refactoring.api_stat_frame_v3.view.ConsoleView;
import refactoring.api_stat_frame_v3.view.StatView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class ConsoleReporter extends ScheduleReporter {

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * Add some default class to improve ease of use.
     * How to solve the RedisMetricsStorage's initialization
     * as it must need some params such as address and port?
     * You can define a Configuration reading the properties,
     * and use it in the construction of RedisMetricsStorage.
     */
    public ConsoleReporter() {
        super(new RedisMetricsStorage(), new Aggregator(), new ConsoleView());
    }

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView statView) {
        super(metricsStorage, aggregator, statView);
    }

    public void startRepeatableReport(long periodSeconds, long durationSeconds) {
        executor.scheduleAtFixedRate(() -> {
            long endTimeMillis = System.currentTimeMillis();
            long startTimeMillis = endTimeMillis - durationSeconds * 1000;

            doReport(startTimeMillis, endTimeMillis);

        }, 0, periodSeconds, TimeUnit.SECONDS);
    }
}
