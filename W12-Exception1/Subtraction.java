/**
 * Subtraction.
 */
public class Subtraction extends BinaryExpression {
    /**
     * Subtraction.
     *
     * @param left Subtraction.
     * @param right Subtraction.
     */
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Subtraction.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "("
                + left.toString()
                + " - "
                + right.toString()
                + ")";
    }

    /**
     * Subtraction.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
