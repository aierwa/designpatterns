package refactoring.api_stat_frame_v3.service;


import refactoring.api_stat_frame_v3.entity.ApiStat;

import java.util.Map;

/**
 * @author xuxiang
 */
public interface ApiStatisticsService {
    Map<String, ApiStat> getApiStat(long startTimeMillis, long endTimeMillis);
    ApiStat getApiStat(String api, long startTimeMillis, long endTimeMillis);
}
