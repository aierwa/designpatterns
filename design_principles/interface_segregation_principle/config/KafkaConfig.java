package interface_segregation_principle.config;

import interface_segregation_principle.inter.Updater;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class KafkaConfig implements Updater {
//    private ConfigSource configSource; // 配置中心，如 zookeeper
    private String address;
    private int timeout;
    private int maxTotal;

//    public KafkaConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }

    public void init(){}


    @Override
    public void update() {
        // 将 configSource 的配置刷到 address，timeout 等
    }
}
