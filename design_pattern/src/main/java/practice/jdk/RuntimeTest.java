package practice.jdk;

/**
 * @author xuxiang
 * 2020/5/8
 */
public class RuntimeTest {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() -> System.out.println("i quit.")));
        runtime.addShutdownHook(new Thread(() -> System.out.println("i quit 2.")));
    }

}
