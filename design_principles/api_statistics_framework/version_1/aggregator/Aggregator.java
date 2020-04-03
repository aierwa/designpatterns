package api_statistics_framework.version_1.aggregator;

import api_statistics_framework.version_1.entity.ApiInfo;
import api_statistics_framework.version_1.entity.ApiStat;

import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 * 提供了一个静态方法的工具类，这种统计方式不易扩展。。。
 */
public class Aggregator {
    public static ApiStat aggregate(List<ApiInfo> apiInfoList, long durationMillis) {
        ApiStat apiStat = new ApiStat();

        long maxRespTime = Long.MIN_VALUE;
        long minRespTime = Long.MAX_VALUE;
        double avgRespTime = 0.0;
        long p999RespTime = -1; // p999百分位数，即假如 p999RespTime=300ms，说明有 99.9% 的请求响应时间低于 300ms
        long p99RespTime = -1;
        long sumRespTime = 0;
        double tps = 0;
        long count = 0;

        for (ApiInfo apiInfo : apiInfoList) {
            if (maxRespTime < apiInfo.getResponseTime()) {
                maxRespTime = apiInfo.getResponseTime();
            }
            if (minRespTime > apiInfo.getResponseTime()) {
                minRespTime = apiInfo.getResponseTime();
            }

            sumRespTime += apiInfo.getResponseTime();
            count ++;
        }

        // todo >> Refactoring >> stat item should be extracted into a private individual function, for future extensions.
        if (count != 0) {
            avgRespTime = sumRespTime * 1.0 / count;
        }

        tps = count * 1.0 / durationMillis;

        // 对 apiInfoList 进行排序
        apiInfoList.sort((o1, o2) -> (int) (o1.getResponseTime() - o2.getResponseTime()));

        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = apiInfoList.get(idx999).getResponseTime();
            p99RespTime = apiInfoList.get(idx99).getResponseTime();
        }

        apiStat.setAvgResponseTime(avgRespTime);
        apiStat.setMaxResponseTime(maxRespTime);
        apiStat.setMinResponseTime(minRespTime);
        apiStat.setCount(count);
        apiStat.setP999ResponseTime(p999RespTime);
        apiStat.setP99ResponseTime(p99RespTime);
        apiStat.setTps(tps);

        return apiStat;
    }
}
