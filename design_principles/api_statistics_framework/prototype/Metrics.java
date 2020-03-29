package api_statistics_framework.prototype;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class Metrics {
    // 响应时间
    private Map<String, List<Long>> responseTimeMap = new HashMap<>();
    // 接口调用时间
    private Map<String, List<Long>> timestampMap = new HashMap<>();

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 记录响应时间
     *
     * @param api          api
     * @param responseTime 响应时间
     */
    public void recordResponseTime(String api, Long responseTime) {
        responseTimeMap.putIfAbsent(api, new ArrayList<>());
        responseTimeMap.get(api).add(responseTime);
    }

    /**
     * 记录调用时间
     *
     * @param api       api
     * @param timestamp 调用时间
     */
    public void recordTimestamp(String api, Long timestamp) {
        timestampMap.putIfAbsent(api, new ArrayList<>());
        timestampMap.get(api).add(timestamp);
    }

    /**
     * 启动周期性统计
     *
     * @param period   周期间隔
     * @param timeUnit 时间单位
     */
    public void startRepeatableReport(long period, TimeUnit timeUnit) {
        executor.scheduleAtFixedRate(() -> {
            System.out.println("开始统计接口数据" );

            Map<String, Map<String, Number>> result = new HashMap<>();
            // 统计响应时间
            responseTimeMap.forEach((api, responseList) -> {
                result.putIfAbsent(api, new HashMap<>());
                LongSummaryStatistics stat = responseList.stream().mapToLong(x -> x).summaryStatistics();
                result.get(api).put("maxResponse", stat.getMax());
                result.get(api).put("minResponse", stat.getMin());
                result.get(api).put("avgResponse", stat.getAverage());
            });

            // 统计调用次数
            timestampMap.forEach((api, timestampList) -> {
                result.putIfAbsent(api, new HashMap<>());
                result.get(api).put("count", timestampList.size());
            });

            // 输出结果
            System.out.println("统计结果： " + result.toString());

        }, 5, period, timeUnit);
    }
}
