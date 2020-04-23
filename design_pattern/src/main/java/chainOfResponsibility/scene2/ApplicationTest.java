package chainOfResponsibility.scene2;

/**
 * @author xuxiang
 */
public class ApplicationTest {
    public static void main(String[] args) {
        SensitiveWordFilterChain chain = new SensitiveWordFilterChain();
        chain.addFilter(new PolicyWordFilter());
        chain.addFilter(new SexyWordFilter());
        System.out.println(chain.filter("黄色电影，法轮功，今天天气好"));
    }
}
