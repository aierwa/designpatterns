package factory.dependency_injection_container.test;

/**
 * @author xuxiang
 */
public class RedisClient {
    private String address;
    private int port;

    public RedisClient(String address, int port) {
        this.address = address;
        this.port = port;
        init();
    }

    private void init() {
        System.out.println("init the redis..." + "address=" + address + ", port=" + port);
    }

    public void set(String key, String value) {
        System.out.println("set value to redis key=" + key + ", value=" + value);
    }

    public String get(String key) {
        System.out.println("get value from redis by key: " + key);
        return null;
    }
}
