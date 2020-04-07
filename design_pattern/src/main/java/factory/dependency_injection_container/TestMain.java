package factory.dependency_injection_container;

import factory.dependency_injection_container.test.RedisClient;

import java.util.Arrays;

/**
 * @author xuxiang
 */
public class TestMain {
    public static void main(String[] args) {
        BeansFactory beansFactory = new BeansFactory();
        BeanDefinition bean1 = new BeanDefinition();
        bean1.setId("redisClient");
        bean1.setClassName("factory.dependency_injection_container.test.RedisClient");
        bean1.setLazyInit(true);
        BeanDefinition.ConstructArg arg1 = new BeanDefinition.ConstructArg(false, String.class, "127.0.0.1");
        BeanDefinition.ConstructArg arg2 = new BeanDefinition.ConstructArg(false, int.class, 6379);
        bean1.setConstructArgs(Arrays.asList(arg1, arg2));

        System.out.println("register beans...");
        beansFactory.addBeanDefinitions(Arrays.asList(bean1));

        System.out.println("get bean redisClient...");
        RedisClient redisClient = (RedisClient) beansFactory.getBean("redisClient");

        redisClient.get("name");
        redisClient.set("name", "xx");
    }
}
