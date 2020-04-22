package strategy.how;

/**
 * strategy interface of different order discount
 *
 * @author xuxiang
 * 2020/4/22
 */
public interface DiscountStrategy {
    double discount(Order order);
}
