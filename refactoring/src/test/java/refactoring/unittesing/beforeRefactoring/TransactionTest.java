package refactoring.unittesing.beforeRefactoring;

import org.junit.Assert;
import org.junit.Test;

import javax.transaction.InvalidTransactionException;

import static org.junit.Assert.*;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public class TransactionTest {

    @Test
    public void execute() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 1L, 2L, 3L, "001");
        // 如果 Transaction 里面依赖的第三方服务和redis之类的不好搞，这里就很难测试了！！
        Assert.assertTrue(transaction.execute());
    }
}