package singleton.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The inner class type to create a singleton.
 *
 * @author xuxiang
 */
public class IdGeneratorInnerClass {
    private AtomicLong atomicLong = new AtomicLong(0);

    private static class IdGeneratorHolder {
        private static IdGeneratorInnerClass instance = new IdGeneratorInnerClass();
    }

    private IdGeneratorInnerClass() {
    }

    /**
     * The instance will be created and initialized when getInstance() was invoked.
     *
     * @return
     */
    public static IdGeneratorInnerClass getInstance() {
        return IdGeneratorHolder.instance;
    }

    public long get() {
        return atomicLong.incrementAndGet();
    }
}
