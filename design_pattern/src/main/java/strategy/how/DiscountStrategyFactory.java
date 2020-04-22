package strategy.how;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiang
 * 2020/4/22
 */
public class DiscountStrategyFactory {
    private static final Map<Order.OrderType, DiscountStrategy> strategies = new HashMap<>();
    static {
        strategies.put(Order.OrderType.NORMAL, new NormalDiscountStrategy());
        strategies.put(Order.OrderType.PROMOTION, new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getStrategy(Order.OrderType orderType) {
        return strategies.get(orderType);
    }

}
