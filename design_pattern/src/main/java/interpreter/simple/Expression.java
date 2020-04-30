package interpreter.simple;

/**
 * Define a expression interface
 *
 * @author xuxiang
 * 2020/4/30
 */
public interface Expression {
    /**
     * interpret expression
     *
     * @return interpreter result number
     */
    long interpret();
}
