import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuxiang
 * 2020/3/26
 * 一个 具备面向对象思想的 购物车
 * 不要滥用 getter setter
 */
public class ShoppingCart {
    private int itemCount;
    private double totalPrice;
    private List<ShoppingItem> items = new ArrayList<>();

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 返回商品列表，但不能修改里面的值
     * @return 商品列表
     */
    public List<ShoppingItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        this.itemCount = 0;
        this.totalPrice = 0;
        items.clear();
    }

    /**
     * 添加购物车
     * @param shoppingItem 商品项
     */
    public void addItem(ShoppingItem shoppingItem) {
        this.items.add(shoppingItem);
        this.itemCount++;
        this.totalPrice += shoppingItem.getPrice();
    }

}
