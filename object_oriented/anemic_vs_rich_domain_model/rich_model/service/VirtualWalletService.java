package rich_model.service;

import rich_model.exception.NoSufficientBalanceException;
import rich_model.model.TransactionEntity;
import rich_model.model.WalletBo;
import rich_model.model.WalletEntity;
import rich_model.repository.TransactionRepository;
import rich_model.repository.VirtualWalletRepository;

import java.math.BigDecimal;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 钱包服务：查询余额、取钱、存钱、转账等
 * ！！基于充血模型！！
 * 数据和方法是定义在一起的，也就是说，让 加减余额、获取余额 这种逻辑（包括里面的入参判断之类）封装到 领域模型 中，
 * 而不是放到 service 中，service 做的事情就只是 执行 加减这么一个动作，然后得到余额结果 更新到数据库中。
 */
public class VirtualWalletService {
    private VirtualWalletRepository virtualWalletRepository; // IOC 注入
    private TransactionRepository transactionRepository; // IOC 注入

    /**
     * 查询钱包实体
     *
     * @param walletId 钱包 id
     * @return 实体
     */
    public WalletBo getVirtualWallet(Long walletId) {
        WalletEntity walletEntity = virtualWalletRepository.getWallet(walletId);
        WalletBo walletBo = null; // convert entity to bo
        return walletBo;
    }

    /**
     * 查询余额
     *
     * @param walletId 钱包 id
     * @return 余额
     */
    public BigDecimal getBalance(Long walletId) {
        return virtualWalletRepository.getBalance(walletId);
    }

    /**
     * 取钱
     *
     * @param walletId 钱包id
     * @param amount   金额
     */
    public void debit(Long walletId, BigDecimal amount) {
        WalletEntity walletEntity = virtualWalletRepository.getWallet(walletId);
        WalletBo walletBo = new WalletBo(); // convert entity to bo
        walletBo.debit(amount);

//        virtualWalletRepository.updateBalance(walletId, walletEntity.getBalance().subtract(amount));
        virtualWalletRepository.updateBalance(walletId, walletBo.getBalance());
    }

    /**
     * 存钱
     *
     * @param walletId 钱包id
     * @param amount   金额
     */
    public void credit(Long walletId, BigDecimal amount) {
        WalletEntity walletEntity = virtualWalletRepository.getWallet(walletId);
        WalletBo walletBo = new WalletBo(); // convert entity to bo
        walletBo.credit(amount);

//        virtualWalletRepository.updateBalance(walletId, walletEntity.getBalance().add(amount));
        virtualWalletRepository.updateBalance(walletId, walletBo.getBalance());
    }

    /**
     * 转账
     *
     * @param fromWalletId 转出的钱包 id
     * @param toWalletId   转入的钱包 id
     * @param amount       转账金额
     */
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setAmount(amount);
        transactionEntity.setStatus(TransactionEntity.Status.TO_BE_EXECUTED);
        transactionRepository.save(transactionEntity);

        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (NoSufficientBalanceException e) {
            // 余额不足
            transactionRepository.updateStatus(transactionEntity.getId(), TransactionEntity.Status.CLOSED);
            throw e;
        } catch (Exception e) {
            transactionRepository.updateStatus(transactionEntity.getId(), TransactionEntity.Status.FAILED);
            throw e;
        }

        transactionRepository.updateStatus(transactionEntity.getId(), TransactionEntity.Status.EXECUTED);

    }
}
