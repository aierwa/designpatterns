package observer.scene1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class UserController {
    private List<RegObserver> regObservers = new ArrayList<>();

    public void setRegObservers(List<RegObserver> regObservers) {
        this.regObservers = regObservers;
    }

    public Long register(String telephone, String password) {
        // userService.register(telephone, password);
        Long id = null;

        // this is a synchronous blocking way, also we can use non-blocking way instead.
        for (RegObserver regObserver : regObservers) {
            regObserver.handleRegSuccess(id);
        }
        return id;
    }
}
