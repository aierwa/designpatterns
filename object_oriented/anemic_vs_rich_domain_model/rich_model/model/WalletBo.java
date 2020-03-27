package rich_model.model;

import rich_model.exception.NoSufficientBalanceException;

import java.math.BigDecimal;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class WalletBo {
    private Long id;
    private Long createTime;
    private BigDecimal balance;

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

    public BigDecimal getBalance() {
        return balance;
    }

    //充血模型就不要暴露余额的 setter 了
    //但是很奇怪，如果这里不定义 setter 的话，那如何 convert entity to bo 呢？ 0.0
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException("");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    // 也许就 取钱 存钱 两个业务感觉这个领域模型很单薄，如果业务多了，就好扩展和维护了，如：
//    public void freeze(BigDecimal amount) { ... }
//    public void unfreeze(BigDecimal amount) { ...}
//    public void increaseOverdraftAmount(BigDecimal amount) { ... }
//    public void decreaseOverdraftAmount(BigDecimal amount) { ... }
//    public void closeOverdraft() { ... }
//    public void openOverdraft() { ... }
}
