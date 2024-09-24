/**
 *
 */
public class Numeral extends Expression {
    private double value;

    /**
     *
     */
    public Numeral() {}

    /**
     *
     * @param value
     */
    public Numeral(double value) {
        this.value = value;
    }

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return String.format("%.0f", value);
    }

    /**
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return value;
    }
}
