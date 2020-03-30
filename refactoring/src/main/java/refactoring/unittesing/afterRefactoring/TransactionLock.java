package refactoring.unittesing.afterRefactoring;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 * 直接按应用场景进行抽象，封装单例的 redis 锁：交易锁
 */
public class TransactionLock {
    public boolean lock(String transactionId) {
        return RedisDistributedLock.getSingletonInstance().lockTransaction(transactionId);
    }

    public void unlock(String transactionId) {
        RedisDistributedLock.getSingletonInstance().unlockTransaction(transactionId);
    }
}
