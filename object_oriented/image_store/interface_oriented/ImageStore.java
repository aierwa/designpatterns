package interface_oriented;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 * 抽象稳定的，将不稳定的实现隐藏起来！
 */
public interface ImageStore {
    String upload(Image image, String bucket);

    void download(String url);
}
