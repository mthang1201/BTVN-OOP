/**
 * BinaryExpression.
 */
public abstract class BinaryExpression extends Expression {
    protected Expression left;

    protected Expression right;

    /**
     *
     * @param left
     * @param right
     */
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}