package refactoring.unittesing.afterRefactoring;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public class RedisDistributedLock {
    public static final RedisDistributedLock instance = new RedisDistributedLock();

    public static RedisDistributedLock getSingletonInstance() {
        return instance;
    }

    public boolean lockTransaction(String id) {
        // lock...
        return true;
    }

    public void unlockTransaction(String id) {
        // unlock...
    }
}
