package api_statistics_framework.version_3.view;

import api_statistics_framework.version_3.entity.ApiStat;

import java.util.Map;

/**
 * @author xuxiang
 */
public class ConsoleView implements StatView {
    @Override
    public void output(Map<String, ApiStat> apiStatMap, long startTimeMillis, long endTimeMillis) {
        System.out.println("Time Span [" + startTimeMillis + " - " + endTimeMillis + "]");
//        System.out.println(apiStatMap.toString());
    }
}
