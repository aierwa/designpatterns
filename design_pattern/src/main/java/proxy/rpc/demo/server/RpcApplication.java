package proxy.rpc.demo.server;

import proxy.rpc.RpcServer;

/**
 * @author xuxiang
 */
public class RpcApplication {
    public static void main(String[] args) throws Exception {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.export(calculatorService, 1234);
    }
}
