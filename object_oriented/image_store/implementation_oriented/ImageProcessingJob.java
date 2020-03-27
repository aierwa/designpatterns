package implementation_oriented;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class ImageProcessingJob {
    private String bucketName;
    private AliyunImageStore aliyunImageStore;

    public ImageProcessingJob(String bucketName, AliyunImageStore aliyunImageStore) {
        this.bucketName = bucketName;
        this.aliyunImageStore = aliyunImageStore;
    }

    public void process(Image image) {
        aliyunImageStore.createBucketIfNotExists(bucketName);
        String token = aliyunImageStore.generateAccessToken();
        aliyunImageStore.uploadToAliyun(image, bucketName, token);
    }

}
