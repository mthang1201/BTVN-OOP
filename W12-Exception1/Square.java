/**
 * Square.
 */
public class Square extends Expression {
    private Expression expression;

    /**
     *
     * @param expression
     */
    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "(" + expression.toString() + ")" + " ^ 2";
    }

    /**
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
