package strategy.how;

/**
 * @author xuxiang
 * 2020/4/22
 */
public class OrderService {
    public double discount(Order order) {
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getStrategy(order.getOrderType());
        return discountStrategy.discount(order);
    }
}
