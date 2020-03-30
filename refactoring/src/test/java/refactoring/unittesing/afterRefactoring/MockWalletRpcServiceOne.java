package refactoring.unittesing.afterRefactoring;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public class MockWalletRpcServiceOne extends WalletRpcService {
    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
        return "1";
    }
}
