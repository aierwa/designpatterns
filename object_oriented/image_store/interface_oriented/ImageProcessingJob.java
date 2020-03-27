package interface_oriented;


import interface_oriented.impl.AliyunImageStore;
import interface_oriented.impl.PrivateImageStore;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class ImageProcessingJob {
    private String bucketName;
    private ImageStore imageStore;

    public ImageProcessingJob(String bucketName, ImageStore imageStore) {
        this.bucketName = bucketName;
        this.imageStore = imageStore;
    }

    public void process(Image image) {
        imageStore.upload(image, bucketName);
    }

    public static void main(String[] args) {
//        ImageStore imageStore = new AliyunImageStore();
//        ImageStore imageStore = new PrivateImageStore();

        // 使用工厂
        String imageStoreType = System.getProperty("imagestore.type");
        ImageStore imageStore = ImageStoreFactory.getInstance().create(imageStoreType);

        ImageProcessingJob job = new ImageProcessingJob("bucket_name", imageStore);
        job.process(new Image());
    }

}
