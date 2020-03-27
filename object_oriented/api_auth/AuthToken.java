
/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class AuthToken {
    // 一分钟过期
    private static final long DEFAULT_EXPIRED_TIME = 60L * 1000;

    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken generate(String url, String appId, String password, long createTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url)
                .append("&")
                .append(appId)
                .append("&")
                .append(password)
                .append("&")
                .append(createTime);
//        String token = md5(stringBuilder.toString());
        String token = "encrypted string";
        return new AuthToken(token, createTime);
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return this.token != null || this.token.equals(authToken.getToken());
    }


}
