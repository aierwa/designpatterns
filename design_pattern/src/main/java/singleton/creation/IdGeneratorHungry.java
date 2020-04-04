package singleton.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The hungry type to create a singleton.
 * @author xuxiang
 */
public class IdGeneratorHungry {
    private AtomicLong atomicLong = new AtomicLong(0);
    private static final IdGeneratorHungry instance = new IdGeneratorHungry();
    private IdGeneratorHungry(){}

    public static IdGeneratorHungry getInstance() {
        return instance;
    }

    public long get() {
        return atomicLong.incrementAndGet();
    }
}
