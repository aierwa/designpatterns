package state.mode1;

/**
 * the state of mario
 *
 * @author xuxiang
 */
public enum  State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int code;

    State(int code) {
        this.code = code;
    }
}
