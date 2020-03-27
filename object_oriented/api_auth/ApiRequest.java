/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public static ApiRequest parseFromUrl(String url) {
        // 解析 url 生成 ApiRequest 对象
        // ...
        return new ApiRequest();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
