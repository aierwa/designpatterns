package observer.scene1;

/**
 * @author xuxiang
 */
public interface RegObserver {
    /**
     * handle process if reg success.
     *
     * @param userId
     */
    void handleRegSuccess(long userId);
}
