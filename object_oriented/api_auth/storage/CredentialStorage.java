package storage;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
