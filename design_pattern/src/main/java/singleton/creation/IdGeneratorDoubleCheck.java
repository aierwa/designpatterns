package singleton.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The double check type to create a singleton.
 *
 * @author xuxiang
 */
public class IdGeneratorDoubleCheck {
    private AtomicLong atomicLong = new AtomicLong(0);
    private static volatile IdGeneratorDoubleCheck instance = null;

    private IdGeneratorDoubleCheck() {
    }

    /**
     * Use temp ref to avoid the performance loss of accessing volatile member.
     *
     * @return
     */
    public static IdGeneratorDoubleCheck getInstance() {
        IdGeneratorDoubleCheck temp = instance;
        if (temp == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                temp = instance;
                if (temp == null) {
                    temp = new IdGeneratorDoubleCheck();
                    instance = temp;
                }
            }
        }
        return instance;
    }

//    public static IdGeneratorDoubleCheck getInstance() {
//        if (instance == null) {
//            synchronized (IdGeneratorDoubleCheck.class) {
//                if (instance == null) {
//                    instance = new IdGeneratorDoubleCheck();
//                }
//            }
//        }
//        return instance;
//    }

    public long get() {
        return atomicLong.incrementAndGet();
    }
}
