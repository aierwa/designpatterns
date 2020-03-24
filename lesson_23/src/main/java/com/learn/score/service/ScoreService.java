package com.learn.score.service;


import com.learn.score.bo.ScoreBo;

import java.util.Date;
import java.util.List;

public interface ScoreService {
    long earnScore(String userId, String channelId, long eventId, int credit, Date expireTime);
    long consumeScore(String userId, String channelId, long eventId, int credit);
    int getAvailableScore(String userId);
    List<ScoreBo> getScoreDetails(String userId);
    List<ScoreBo> getEarnedScoreDetails(String userId);
    List<ScoreBo> getConsumedScoreDetails(String userId);
}
