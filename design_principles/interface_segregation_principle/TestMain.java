package interface_segregation_principle;

import interface_segregation_principle.config.KafkaConfig;
import interface_segregation_principle.config.RedisConfig;
import interface_segregation_principle.scheduler.ScheduleUpdater;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class TestMain {
    public static void main(String[] args) {
        RedisConfig redisConfig = new RedisConfig();
        KafkaConfig kafkaConfig = new KafkaConfig();

        ScheduleUpdater redisConfigUpdater = new ScheduleUpdater(redisConfig, 100, 1000);
        redisConfigUpdater.run();

        ScheduleUpdater kafkaConfigUpdater = new ScheduleUpdater(kafkaConfig, 200, 2000);
        kafkaConfigUpdater.run();
    }
}
