/**
 * ExpressionTest.
 */
public class ExpressionTest {
    /**
     * ExpressionTest.
     *
     * @param args ExpressionTest.
     */
    public static void main(String[] args) {
        Expression expression = new Square(
                new Addition(
                        new Subtraction(
                                new Square(new Numeral(10)),
                                new Numeral(3)
                        ),
                        new Multiplication(new Numeral(4),
                                new Numeral(3)
                        )
                )
        );

        System.out.println(expression.toString());
        System.out.println(expression.evaluate());
    }
}
