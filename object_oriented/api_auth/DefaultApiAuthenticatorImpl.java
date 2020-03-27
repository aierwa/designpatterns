import storage.CredentialStorage;
import storage.impl.RedisCredentialStorage;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {
    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        this.credentialStorage = new RedisCredentialStorage();
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.parseFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        AuthToken clientAuthToken = new AuthToken(apiRequest.getToken(), apiRequest.getTimestamp());
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("token 已过期");
        }

        String password = credentialStorage.getPasswordByAppId(apiRequest.getAppId());
        AuthToken serverAuthToken = AuthToken.generate(apiRequest.getBaseUrl(), apiRequest.getAppId(), password, apiRequest.getTimestamp());
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("token 验证不通过");
        }
    }
}
