package interpreter.simple;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class NumberExpression implements Expression {
    private long number;

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}
