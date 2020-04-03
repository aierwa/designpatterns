package api_statistics_framework.version_3.view;

import api_statistics_framework.version_3.entity.ApiStat;

import java.util.Map;

/**
 * View for the result of stat.
 * face interface programming.
 * View don't coupling MetricsStorage, just for output with the given stat map.
 *
 * @author xuxiang
 */
public interface StatView {
    void output(Map<String, ApiStat> apiStatMap, long startTimeMillis, long endTimeMillis);
}
