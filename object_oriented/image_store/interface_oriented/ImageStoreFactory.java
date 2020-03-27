package interface_oriented;

import interface_oriented.impl.AliyunImageStore;
import interface_oriented.impl.PrivateImageStore;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class ImageStoreFactory {
    private static ImageStoreFactory factory = new ImageStoreFactory();
    private static Map<String ,ImageStore> strategyMap = new HashMap<>();

    private ImageStoreFactory(){}

    static {
        strategyMap.put("aliyun", new AliyunImageStore());
        strategyMap.put("private", new PrivateImageStore());
    }

    public ImageStore create(String imageStoreType) {
        return strategyMap.get(imageStoreType);
    }

    public static ImageStoreFactory getInstance(){
        return factory;
    }
}
