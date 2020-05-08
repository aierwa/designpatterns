package practice.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author xuxiang
 * 2020/5/8
 */
public class ShortMsgObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("send short msg: " + arg);
    }
}
