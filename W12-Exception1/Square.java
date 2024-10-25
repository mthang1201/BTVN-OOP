/**
 * Square.
 */
public class Square extends Expression {
    private Expression expression;

    /**
     * Square.
     *
     * @param expression Square.
     */
    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     * Square.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "("
                + expression.toString()
                + ")"
                + " ^ 2";
    }

    /**
     * Square.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
