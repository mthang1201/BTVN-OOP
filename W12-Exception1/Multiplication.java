/**
 *
 */
public class Multiplication extends BinaryExpression {
    /**
     *
     * @param left
     * @param right
     */
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    /**
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
