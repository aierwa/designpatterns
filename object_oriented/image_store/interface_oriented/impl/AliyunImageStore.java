package interface_oriented.impl;

import interface_oriented.Image;
import interface_oriented.ImageStore;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class AliyunImageStore implements ImageStore {

    @Override
    public String upload(Image image, String bucket) {
        createBucketIfNotExists(bucket);
        String token = generateAccessToken();
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

    private String generateAccessToken() {
        return null;
    }
}
