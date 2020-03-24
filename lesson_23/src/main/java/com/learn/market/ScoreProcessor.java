package com.learn.market;

public abstract class ScoreProcessor {
    public void process(String userId, String channelId, long eventId){
        // 获取积分规则
        getScoreRule(channelId);
    }

    protected abstract void getScoreRule(String channelId);
}
