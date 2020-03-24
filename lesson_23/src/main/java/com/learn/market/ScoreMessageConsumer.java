package com.learn.market;


import java.util.HashMap;
import java.util.Map;

public class ScoreMessageConsumer {

    public void consumer(String infoStr){
        Map<String, Object> info = new HashMap<String, Object>();
        ScoreProcessor processor = null;
        Integer type = (Integer) info.get("scoreType");
        if (type == 1) {

        }
    }
}
