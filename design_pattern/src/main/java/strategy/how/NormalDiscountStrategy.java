package strategy.how;

/**
 * @author xuxiang
 * 2020/4/22
 */
public class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount(Order order) {
        return 0;
    }
}
