package api_statistics_framework.version_3.aggregator;

import api_statistics_framework.version_3.entity.ApiInfo;
import api_statistics_framework.version_3.entity.ApiStat;

import java.util.*;

/**
 * Aggregator for api stats.
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class Aggregator {

    /**
     * Aggregate multiple apis' stat
     * @param apiInfoMap apiInfo map
     * @param durationMillis durationMillis of stat interval
     * @return stat map, the key is api string.
     */
    public Map<String, ApiStat> aggregate(Map<String, List<ApiInfo>> apiInfoMap, long durationMillis) {
        Map<String, ApiStat> statMap = new HashMap<>();
        for (Map.Entry<String, List<ApiInfo>> entry : apiInfoMap.entrySet()) {
            String api = entry.getKey();
            List<ApiInfo> apiInfoList = entry.getValue();
            statMap.put(api, doAggregate(apiInfoList, durationMillis));
        }
        return statMap;
    }


    public ApiStat doAggregate(List<ApiInfo> apiInfoList, long durationMillis) {
        ApiStat apiStat = new ApiStat();

        List<Long> respTimeList = new ArrayList<>();
        for (ApiInfo apiInfo : apiInfoList) {
            respTimeList.add(apiInfo.getResponseTime());
        }

        apiStat.setAvgResponseTime(avg(respTimeList));
        apiStat.setMaxResponseTime(max(respTimeList));
        apiStat.setMinResponseTime(min(respTimeList));
        apiStat.setCount(respTimeList.size());
        apiStat.setP999ResponseTime(p999RespTime(respTimeList));
        apiStat.setP99ResponseTime(p99RespTime(respTimeList));
        apiStat.setTps(tps(respTimeList.size(), durationMillis));

        return apiStat;
    }


    private double avg(List<Long> dataset) {
        return dataset.stream().mapToLong(l -> l).average().getAsDouble();
    }
    private long max(List<Long> dataset) {
        return dataset.stream().mapToLong(l -> l).max().getAsLong();
    }
    private long min(List<Long> dataset) {
        return dataset.stream().mapToLong(l -> l).min().getAsLong();
    }
    private double tps(long count, long durationSeconds) {
        return count * 1.0 / durationSeconds;
    }
    private long p999RespTime(List<Long> dataset) {
        Collections.sort(dataset);
        return dataset.get((int) (dataset.size() * 0.999));
    }
    private long p99RespTime(List<Long> dataset) {
        Collections.sort(dataset);
        return dataset.get((int) (dataset.size() * 0.99));
    }


}
