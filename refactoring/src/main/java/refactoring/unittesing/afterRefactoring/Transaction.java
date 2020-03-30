package refactoring.unittesing.afterRefactoring;

import javax.transaction.InvalidTransactionException;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public class Transaction {
    private static final Long MILLIS_14_DAYS = 14 * 24 * 60 * 60 * 1000L;
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    // 依赖注入，方便测试 mock
    private WalletRpcService walletRpcService;
    // 抽象单例为一个锁，方便测试 mock
    private TransactionLock transactionLock;

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTED;
        this.createTimestamp = System.currentTimeMillis();
    }

    public STATUS getStatus() {
        return status;
    }

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }
    public void setTransactionLock(TransactionLock transactionLock) {
        this.transactionLock = transactionLock;
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || sellerId == null) {
            throw new InvalidTransactionException("交易非法");
        }
        // 如果已经执行了就退出
        if (getStatus() == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {
            isLocked = transactionLock.lock(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (getStatus() == STATUS.EXECUTED) return true; // double check

//            if (executionInvokedTimestamp - createTimestamp > MILLIS_14_DAYS) {
//                this.status = STATUS.EXPIRED;
//                return false;
//            }
            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }

//            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);

            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                transactionLock.unlock(id);
            }
        }
    }

    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp > MILLIS_14_DAYS;
    }
}
