package strategy.how;

/**
 * @author xuxiang
 * 2020/4/22
 */
public class Order {
    private OrderType orderType;

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public enum OrderType {
        NORMAL, PROMOTION
    }
}
