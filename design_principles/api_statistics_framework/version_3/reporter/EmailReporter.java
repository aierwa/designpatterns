package api_statistics_framework.version_3.reporter;

import api_statistics_framework.version_3.aggregator.Aggregator;
import api_statistics_framework.version_3.entity.ApiInfo;
import api_statistics_framework.version_3.storage.MetricsStorage;
import api_statistics_framework.version_3.view.StatView;

import java.util.*;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class EmailReporter extends ScheduleReporter {
    private static final long DAY_HOUR_IN_SECONDS = 86400L;
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatView statView;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView statView) {
        super(metricsStorage, aggregator, statView);
    }

    public void startRepeatableReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 得到首次执行时间
        Date firstTime = calendar.getTime();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long endTimeMillis = System.currentTimeMillis();
                long startTimeMillis = endTimeMillis - DAY_HOUR_IN_SECONDS * 1000;
                doReport(startTimeMillis, endTimeMillis);
            }
        }, firstTime, DAY_HOUR_IN_SECONDS * 1000);
    }
}
