package com.learn.score.dao;

import com.learn.score.entity.ScoreEntity;

import java.util.List;

public interface ScoreRepository {
    int save(ScoreEntity scoreEntity);
    int getAvailableScore(String userId);
    List<ScoreEntity> getScoreDetails();
}
