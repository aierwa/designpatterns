package refactoring.api_stat_frame_v3.view;


import refactoring.api_stat_frame_v3.entity.ApiStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xuxiang
 */
public class MailStatView implements StatView {
    private List<String> toAddresses = new ArrayList<>();

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, ApiStat> apiStatMap, long startTimeMillis, long endTimeMillis) {
        System.out.println("组装 html 文本...");
        System.out.println("发送 html 邮件...");
    }
}

