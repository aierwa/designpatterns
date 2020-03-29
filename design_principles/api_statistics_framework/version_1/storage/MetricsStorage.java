package api_statistics_framework.version_1.storage;

import api_statistics_framework.version_1.entity.ApiInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public interface MetricsStorage {
    /**
     * 存信息
     *
     * @param apiInfo apiInfo
     */
    void saveApiInfo(ApiInfo apiInfo);

    /**
     * 根据api 取信息
     *
     * @param api            api
     * @param startTimestamp 开始时间
     * @param endTimestamp   结束时间
     * @return apiInfo 列表
     */
    List<ApiInfo> getApiInfos(String api, long startTimestamp, long endTimestamp);

    /**
     * 取信息
     *
     * @param startTimestamp 开始时间
     * @param endTimestamp   结束时间
     * @return api为key的map，包含 apiInfo 列表
     */
    Map<String, List<ApiInfo>> getApiInfos(long startTimestamp, long endTimestamp);
}
