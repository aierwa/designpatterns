package interpreter.simple;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author xuxiang
 * 2020/5/7
 */
public class ExpressionInterpreter {
    private Deque<Expression> numbers = new LinkedList<>();
    private static Set<String> operators = new HashSet<>();

    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    /**
     * Interpret the expression
     *
     * @param expression like 1 2 3 4 + * -
     * @return result like (1 + 2) * 3 - 4 = 5
     */
    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < length / 2 + 1; i++) {
            numbers.add(new NumberExpression(elements[i]));
        }

        for (int i = (length + 1) / 2; i < length; i++) {
            String operator = elements[i];
            if (!isValidOperator(operator)) {
                throw new IllegalArgumentException("Expression is invalid: " + operator);
            }
            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression combinedExp = null;
            if ("+".equals(operator)) {
                combinedExp = new AdditionExpression(exp1, exp2);
            } else if ("-".equals(operator)) {
                combinedExp = new SubstractionExpression(exp1, exp2);
            } else if ("*".equals(operator)) {
                combinedExp = new MultiplicationExpression(exp1, exp2);
            } else if ("/".equals(operator)) {
                combinedExp = new DivisionExpression(exp1, exp2);
            }
            numbers.addFirst(combinedExp);
        }

        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Expression is invalid: " + expression);
        }

        return numbers.pop().interpret();
    }

    private boolean isValidOperator(String operator) {
        return operators.contains(operator);
    }

    public static void main(String[] args) {
        ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();
        long re = expressionInterpreter.interpret("1 2 3 4 + * -");
        System.out.println(re);
        expressionInterpreter.interpret("1 2 3 4 5 + * -");
    }
}
