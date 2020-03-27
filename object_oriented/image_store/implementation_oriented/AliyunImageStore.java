package implementation_oriented;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * <p>
 * 一个阿里云图片存储 的组件
 * 此例不好在于：
 * 面向了实现编程，不能应对未来的需求变化，比如不上传到Aliyun了，就需要改较多的代码
 * 方法命名过于具体化，uploadToAliyun 带有 aliyun 字样
 * 像 generateAccessToken 这种逻辑操作不应该暴露给使用者
 */
public class AliyunImageStore {
    /**
     * 创建 bucket(可认为是一个文件夹)
     *
     * @param bucketName bucket
     */
    public void createBucketIfNotExists(String bucketName) {
        // 创建 bucket
        // 失败后 抛出异常
    }

    /**
     * 获取 访问权限token
     *
     * @return token
     */
    public String generateAccessToken() {
        return null;
    }

    /**
     * 上传图片到阿里云
     *
     * @param image       图片
     * @param bucketName  bucket
     * @param accessToken token
     * @return 阿里云上存储的图片地址
     */
    public String uploadToAliyun(Image image, String bucketName, String accessToken) {
        return null;
    }

    /**
     * 从阿里云下载图片
     *
     * @param url         图片地址
     * @param accessToken token
     * @return 图片对象
     */
    public Image downloadFromAliyun(String url, String accessToken) {
        return null;
    }

}
