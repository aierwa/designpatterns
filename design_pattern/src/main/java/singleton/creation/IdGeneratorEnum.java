package singleton.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The enum type to create a singleton.
 *
 * @author xuxiang
 */
public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicLong atomicLong = new AtomicLong(0);


    public long get() {
        return atomicLong.incrementAndGet();
    }
}
