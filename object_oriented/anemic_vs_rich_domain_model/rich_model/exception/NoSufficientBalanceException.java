package rich_model.exception;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class NoSufficientBalanceException extends RuntimeException {
    public NoSufficientBalanceException(String message) {
        super(message);
    }
}
