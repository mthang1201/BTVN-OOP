/**
 * Division.
 */
public class Division extends BinaryExpression {
    /**
     * Division.
     *
     * @param left Division.
     * @param right Division.
     */
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Division.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "("
                + left.toString()
                + " / "
                + right.toString()
                + ")";
    }

    /**
     * Division.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        return left.evaluate() / right.evaluate();
    }
}
