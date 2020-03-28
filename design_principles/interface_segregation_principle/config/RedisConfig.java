package interface_segregation_principle.config;

import interface_segregation_principle.inter.Updater;
import interface_segregation_principle.inter.Viewer;

import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class RedisConfig implements Updater, Viewer {
//    private ConfigSource configSource; // 配置中心，如 zookeeper
    private String address;
    private int timeout;
    private int maxTotal;

//    public RedisConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }

    public void init(){}


    @Override
    public void update() {
        // 将 configSource 的配置刷到 address，timeout 等
    }

    @Override
    public String outputPlainText() {
        return null;
    }

    @Override
    public Map<String, Object> output() {
        return null;
    }
}
