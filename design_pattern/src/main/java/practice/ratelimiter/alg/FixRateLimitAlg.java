package practice.ratelimiter.alg;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现固定窗口限流的算法
 *
 * @author xuxiang
 */
public class FixRateLimitAlg implements RateLimitAlg {
    private static final long TRY_LOCK_TIMEOUT = 200L;
    /**
     * 计时器
     */
    private Stopwatch stopwatch = Stopwatch.createStarted();
    /**
     * 计数器
     */
    private AtomicInteger counter = new AtomicInteger(0);
    /**
     * final 修饰，不能更改
     */
    private final int limit;
    private final int unit;
    /**
     * 加锁
     */
    private Lock lock = new ReentrantLock();

    public FixRateLimitAlg(int limit, int unit) {
        this.limit = limit;
        this.unit = unit;
    }

    /**
     * 尝试访问
     *
     * @return true 则可访问，false 则不可继续访问
     */
    @Override
    public boolean tryAcquire() {
        // 如果当前计数小于 limit，那么可以继续访问
        int currentCount = counter.incrementAndGet();
        if (currentCount <= limit) {
            return true;
        }

        // 如果大于 limit，那么继续判断是否过了时间窗口
        // 若没有过窗口，那就需要限流，若超过了时间窗口，则进行重置计数
        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(unit)) {
                        counter.set(0);
                        stopwatch.reset().start();
                    }
                    currentCount = counter.incrementAndGet();
                    return currentCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new RuntimeException("tryAcquire lock for too long time.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("lock interrupted.");
        }
    }

}
