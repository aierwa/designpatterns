package inversion_of_control;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

//    public static void main(String[] args) {
//        for (TestCase testCase : testCases) {
//            testCase.run();
//        }
//    }

    public void run() {
        for (TestCase testCase : testCases) {
            testCase.run();
        }
    }
}
