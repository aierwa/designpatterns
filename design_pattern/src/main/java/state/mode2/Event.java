package state.mode2;

/**
 * events of mario actions
 *
 * @author xuxiang
 */
public enum  Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MEET_MONSTER(3),
    ;

    private int code;

    Event(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
