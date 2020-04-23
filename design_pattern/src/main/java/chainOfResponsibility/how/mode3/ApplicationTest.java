package chainOfResponsibility.how.mode3;


/**
 * @author xuxiang
 */
public class ApplicationTest {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();

        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());

        handlerChain.handle();
    }
}
