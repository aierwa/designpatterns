package anemic_model.repository;

import anemic_model.model.TransactionEntity;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 交易流水
 */
public class TransactionRepository {

    public int save(TransactionEntity transactionEntity) {
        return 0;
    }

    public int updateStatus(Long transactionId, TransactionEntity.Status status) {
        return 0;
    }

}
