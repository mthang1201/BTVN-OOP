/**
 * Multiplication.
 */
public class Multiplication extends BinaryExpression {
    /**
     * Multiplication.
     *
     * @param left Multiplication.
     * @param right Multiplication.
     */
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Multiplication.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "("
                + left.toString()
                + " * "
                + right.toString()
                + ")";
    }

    /**
     * Multiplication.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
