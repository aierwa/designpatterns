package practice.ratelimiter.alg;

/**
 * 将限流算法抽象为接口，方便扩展
 *
 * @author xuxiang
 */
public interface RateLimitAlg {
    boolean tryAcquire();
}
