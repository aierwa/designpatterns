package practice.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author xuxiang
 * 2020/5/12
 */
public class CacheDemo {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(100)
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .build();

        cache.put("name", "xx");
        String val = cache.getIfPresent("name");
        System.out.println(val);

        Thread.sleep(10000);
        String val2 =cache.getIfPresent("name");
        System.out.println(val2);
    }
}
