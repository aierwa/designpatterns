package anemic_model.service;

import anemic_model.exception.NoSufficientBalanceException;
import anemic_model.model.TransactionEntity;
import anemic_model.model.WalletBo;
import anemic_model.model.WalletEntity;
import anemic_model.repository.TransactionRepository;
import anemic_model.repository.VirtualWalletRepository;

import java.math.BigDecimal;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 钱包服务：查询余额、取钱、存钱、转账等
 * ！！基于贫血模型！！
 * 数据和方法是分开的，所有逻辑如 钱的增减操作 放在服务里面
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
        if (walletEntity.getBalance().compareTo(amount) < 0) {
            throw new NoSufficientBalanceException("");
        }
        virtualWalletRepository.updateBalance(walletId, walletEntity.getBalance().subtract(amount));
    }

    /**
     * 存钱
     *
     * @param walletId 钱包id
     * @param amount   金额
     */
    public void credit(Long walletId, BigDecimal amount) {
        WalletEntity walletEntity = virtualWalletRepository.getWallet(walletId);
        virtualWalletRepository.updateBalance(walletId, walletEntity.getBalance().add(amount));
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
