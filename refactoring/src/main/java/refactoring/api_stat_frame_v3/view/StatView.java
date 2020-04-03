package refactoring.api_stat_frame_v3.view;


import refactoring.api_stat_frame_v3.entity.ApiStat;

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
