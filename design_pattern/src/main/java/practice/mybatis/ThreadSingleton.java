package practice.mybatis;

/**
 * 线程唯一单例实现
 *
 * @author xuxiang
 */
public class ThreadSingleton {
    private static final ThreadLocal<ThreadSingleton> LOCAL = new ThreadLocal<>();

    private ThreadSingleton() {
    }

    /**
     * get a singleton
     *
     * @return ThreadSingleton
     */
    public static ThreadSingleton getInstance() {
        ThreadSingleton singleton = LOCAL.get();
        if (singleton == null) {
            singleton = new ThreadSingleton();
            LOCAL.set(singleton);
        }
        return singleton;
    }
}
