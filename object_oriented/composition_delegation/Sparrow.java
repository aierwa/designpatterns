import inter.Flyable;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 麻雀类
 * 如果有很多鸟都会飞，这个时候如果实现 Flyable 接口的话都得去实现以下 fly 方法
 * 但很多 fly 的方法是一样的，这个时候可以使用 组合 + 委托
 */
public class Sparrow implements Flyable {
    private Flyability flyability = new Flyability();   // 组合 composition

    @Override
    public void fly() {
        flyability.fly();   // 委托 delegation
    }
}
