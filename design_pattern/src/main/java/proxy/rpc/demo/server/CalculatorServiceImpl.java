package proxy.rpc.demo.server;

/**
 * @author xuxiang
 */
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
