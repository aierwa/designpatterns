package api_statistics_framework.version_3.service;

import api_statistics_framework.version_3.entity.ApiStat;

import java.util.Map;

/**
 * @author xuxiang
 */
public interface ApiStatisticsService {
    Map<String, ApiStat> getApiStat(long startTimeMillis, long endTimeMillis);
    ApiStat getApiStat(String api, long startTimeMillis, long endTimeMillis);
}
