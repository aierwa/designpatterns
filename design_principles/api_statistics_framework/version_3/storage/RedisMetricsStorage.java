package api_statistics_framework.version_3.storage;

import api_statistics_framework.version_3.entity.ApiInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class RedisMetricsStorage implements MetricsStorage{

    @Override
    public void saveApiInfo(ApiInfo apiInfo) {
        System.out.println("Save apiInfo to Redis: " + apiInfo);
    }

    @Override
    public List<ApiInfo> getApiInfos(String api, long startTimestamp, long endTimestamp) {
        System.out.println("get apiInfos from Redis, api=" + api);
        return new ArrayList<>();
    }

    @Override
    public Map<String, List<ApiInfo>> getApiInfos(long startTimestamp, long endTimestamp) {
        System.out.println("get api and apiInfos map from Redis");
        return new HashMap<>();
    }
}
