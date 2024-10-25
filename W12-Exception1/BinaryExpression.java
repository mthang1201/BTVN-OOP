/**
 * BinaryExpression.
 */
public abstract class BinaryExpression extends Expression {
    protected Expression left;

    protected Expression right;

    /**
     * BinaryExpression.
     *
     * @param left BinaryExpression.
     * @param right BinaryExpression.
     */
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}