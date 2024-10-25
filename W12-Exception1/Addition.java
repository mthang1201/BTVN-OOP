/**
 * Addition.
 */
public class Addition extends BinaryExpression {
    /**
     * Addition.
     *
     * @param left Addition.
     * @param right Addition.
     */
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Addition.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "("
                + left.toString()
                + " + "
                + right.toString()
                + ")";
    }

    /**
     * Addition.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
