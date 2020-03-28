import entity.ApiStatInfo;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class AlertTestMain {
    public static void main(String[] args) {
        ApiStatInfo homeApi = new ApiStatInfo("/home", 2000, 120, 20, 2);
        System.out.println("START 检测 api：" + homeApi.getApi());
        Alert.getInstance().check(homeApi);
        System.out.println("END 检测 api：" + homeApi.getApi());


        ApiStatInfo fooApi = new ApiStatInfo("/foo", 20, 10, 20, 1);
        System.out.println("START 检测 api：" + fooApi.getApi());
        Alert.getInstance().check(fooApi);
        System.out.println("END 检测 api：" + fooApi.getApi());

    }
}
