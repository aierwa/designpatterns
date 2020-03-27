/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 鉴权抽象成一个接口，封装不确定的 鉴权 方法实现
 */
public interface ApiAuthenticator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
