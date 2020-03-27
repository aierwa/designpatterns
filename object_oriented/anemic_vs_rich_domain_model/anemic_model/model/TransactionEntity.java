package anemic_model.model;

import java.math.BigDecimal;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class TransactionEntity {
    private Long id;
    private Long createTime;
    private BigDecimal amount;
    private Long fromWalletId;
    private Long toWalletId;

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getFromWalletId() {
        return fromWalletId;
    }

    public void setFromWalletId(Long fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public Long getToWalletId() {
        return toWalletId;
    }

    public void setToWalletId(Long toWalletId) {
        this.toWalletId = toWalletId;
    }

    public enum  Status {
        TO_BE_EXECUTED,
        EXECUTED,
        CLOSED,
        FAILED
    }
}
