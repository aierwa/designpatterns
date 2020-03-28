package interface_segregation_principle.config;


import interface_segregation_principle.inter.Viewer;

import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class MysqlConfig implements Viewer {
//    private ConfigSource configSource; // 配置中心，如 zookeeper
    private String address;
    private int timeout;
    private int maxTotal;

//    public MysqlConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }

    public void init(){}

    @Override
    public String outputPlainText() {
        return null;
    }

    @Override
    public Map<String, Object> output() {
        return null;
    }
}
