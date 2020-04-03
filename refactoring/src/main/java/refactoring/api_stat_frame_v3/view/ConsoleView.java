package refactoring.api_stat_frame_v3.view;


import refactoring.api_stat_frame_v3.entity.ApiStat;

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
