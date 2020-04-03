package api_statistics_framework.version_2.reporter;

import api_statistics_framework.version_2.aggregator.Aggregator;
import api_statistics_framework.version_2.entity.ApiInfo;
import api_statistics_framework.version_2.entity.ApiStat;
import api_statistics_framework.version_2.storage.MetricsStorage;
import api_statistics_framework.version_2.view.StatView;

import java.util.*;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class EmailReporter {
    private static final long DAY_HOUR_IN_SECONDS = 86400L;
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatView statView;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView statView) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statView = statView;
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

                Map<String, List<ApiInfo>> apiInfos = metricsStorage.getApiInfos(startTimeMillis, endTimeMillis);

                statView.output(aggregator.aggregate(apiInfos, DAY_HOUR_IN_SECONDS * 1000), startTimeMillis, endTimeMillis);
            }
        }, firstTime, DAY_HOUR_IN_SECONDS * 1000);
    }
}
