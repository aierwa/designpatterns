package proxy.dynamicproxyCglib;


/**
 * @author xuxiang
 */
public class OrderServiceImpl {
    public void addOrder() {
        System.out.println("add order...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
