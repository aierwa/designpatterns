package api_statistics_framework.version_1.reporter;

import api_statistics_framework.version_1.aggregator.Aggregator;
import api_statistics_framework.version_1.entity.ApiInfo;
import api_statistics_framework.version_1.entity.ApiStat;
import api_statistics_framework.version_1.storage.MetricsStorage;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class EmailReporter extends BaseReporter {
    private static final long DAY_HOUR_IN_SECONDS = 86400L;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage) {
        super(metricsStorage);
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
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
                // 取数据
                Map<String, ApiStat> statMap = getApiStat(System.currentTimeMillis(), DAY_HOUR_IN_SECONDS);

                // 生成html文本
//                String html = ...
                // 发送邮件
//                MailSender.send(toAddresses, html);
            }
        }, firstTime, DAY_HOUR_IN_SECONDS * 1000);
    }
}
