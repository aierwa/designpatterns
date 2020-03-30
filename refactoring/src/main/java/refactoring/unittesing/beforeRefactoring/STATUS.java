package refactoring.unittesing.beforeRefactoring;

/**
 * @Author xuxiang
 * @Date 2020/3/30
 */
public enum STATUS {
    TO_BE_EXECUTED(0),
    EXECUTED(1),
    EXPIRED(2),
    FAILED(3),
    ;
    private int code;

    STATUS(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
