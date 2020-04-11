package proxy.rpc.demo.client;

import proxy.rpc.RpcClient;

/**
 * @author xuxiang
 */
public class ClientDemo {
    public static void main(String[] args) {
        RpcClient rpcClient = new RpcClient();
        // get a proxy class of CalculatorService
        CalculatorService calculatorService = rpcClient.refer(CalculatorService.class, "127.0.0.1", 1234);

        int result = calculatorService.add(10, 20);
        System.out.println("10 + 20 = " + result);
    }
}
