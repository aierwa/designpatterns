package chainOfResponsibility.how.mode3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class HandlerChain {
    private List<Handler> handlerList = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlerList.add(handler);
    }

    public void handle() {
        for (Handler handler : handlerList) {
            handler.handle();
        }
    }
}
