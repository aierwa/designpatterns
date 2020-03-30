package refactoring.unittesing.afterRefactoring;

import org.junit.Assert;
import org.junit.Test;

import javax.transaction.InvalidTransactionException;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public class TransactionTest {

    @Test
    public void execute() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001");
        // mock WalletRpcService
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        // mock TransactionLock
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
            public void unlock(String id) {}
        });

        Assert.assertTrue(transaction.execute());
        Assert.assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    @Test
    public void execute_buyerIdOrSellerIdNull() {
        Transaction transaction = new Transaction(null, null, null, 3L, "001");
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
            public void unlock(String id) {}
        });

        Assert.assertThrows(InvalidTransactionException.class, transaction::execute);
    }

    @Test
    public void execute_expired() throws InvalidTransactionException {
        // mock isExpired
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001"){
            protected boolean isExpired() {
                return true;
            }
        };
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
            public void unlock(String id) {}
        });

        Assert.assertFalse(transaction.execute());
        Assert.assertEquals(STATUS.EXPIRED, transaction.getStatus());
    }

    @Test
    public void execute_executed() throws InvalidTransactionException {
        // mock isExpired
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001"){
            public STATUS getStatus() {
                return STATUS.EXECUTED;
            }
        };
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
            public void unlock(String id) {}
        });

        Assert.assertTrue(transaction.execute());
    }

    @Test
    public void execute_walletRpcServiceNull() throws InvalidTransactionException {
        // mock isExpired
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001");
        transaction.setWalletRpcService(new MockWalletRpcServiceTwo());
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
            public void unlock(String id) {}
        });

        Assert.assertFalse(transaction.execute());
        Assert.assertEquals(STATUS.FAILED, transaction.getStatus());
    }

    @Test
    // 测试用例6：也就是 上锁 失败？
    public void execute_executing() throws InvalidTransactionException {
        // mock isExpired
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001");
        transaction.setWalletRpcService(new MockWalletRpcServiceTwo());
        transaction.setTransactionLock(new TransactionLock(){
            public boolean lock(String id) {
                return false;
            }
            public void unlock(String id) {}
        });

        Assert.assertFalse(transaction.execute());
    }
}