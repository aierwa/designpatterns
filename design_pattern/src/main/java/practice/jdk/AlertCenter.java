package practice.jdk;

import java.util.Observable;

/**
 * @author xuxiang
 * 2020/5/8
 */
public class AlertCenter extends Observable {

    public AlertCenter() {
        this.addObserver(new ShortMsgObserver());
        this.addObserver(new MailObserver());
    }

    public void sendAlert(String message){
        this.setChanged();
        this.notifyObservers(message);
    }

    public static void main(String[] args) {
        AlertCenter alertCenter = new AlertCenter();
        alertCenter.sendAlert("This is a alarm message.");
    }
}
