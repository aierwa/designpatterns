package singleton.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The lazy type to create a singleton.
 *
 * @author xuxiang
 */
public class IdGeneratorLazy {
    private AtomicLong atomicLong = new AtomicLong(0);
    private static IdGeneratorLazy instance = null;

    private IdGeneratorLazy() {
    }

    /**
     * Synchronized statement will influence the performance of getInstance() every invoked.
     *
     * @return
     */
    public static synchronized IdGeneratorLazy getInstance() {
        if (instance == null) {
            instance = new IdGeneratorLazy();
        }
        return instance;
    }

    public long get() {
        return atomicLong.incrementAndGet();
    }
}
