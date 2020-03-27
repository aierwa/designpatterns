package interface_oriented.impl;

import interface_oriented.Image;
import interface_oriented.ImageStore;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 私有云图片上传，不需要 accessToken 方法了
 */
public class PrivateImageStore implements ImageStore {

    @Override
    public String upload(Image image, String bucket) {
        createBucketIfNotExists(bucket);
        // upload...
        return null;
    }

    @Override
    public void download(String url) {

    }

    private void createBucketIfNotExists(String bucketName) {
        // 创建 bucket
        // 失败后 抛出异常
    }
}
