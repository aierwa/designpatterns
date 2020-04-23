package chainOfResponsibility.how.mode1;

/**
 * @author xuxiang
 */
public class HandlerChain {
    /**
     * head of handlers chain
     */
    private Handler head;
    /**
     * tail of handlers chain
     */
    private Handler tail;

    public void addHandler(Handler handler) {
        // the newly added handler should be guaranteed no successor.
        handler.setSuccessor(null);

        //first handler referenced by head and tail
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        // set the current tail's successor to the passed handler
        tail.setSuccessor(handler);
        // and then reference the tail to the passed handler
        tail = handler;
    }

    /**
     * handle through out the chain.
     */
    public void handle() {
        if (head != null) {
            head.handler();
        }
    }
}
