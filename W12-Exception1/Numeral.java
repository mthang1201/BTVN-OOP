/**
 * Numeral.
 */
public class Numeral extends Expression {
    private double value;

    /**
     * Numeral.
     */
    public Numeral() {}

    /**
     * Numeral.
     *
     * @param value Numeral.
     */
    public Numeral(double value) {
        this.value = value;
    }

    /**
     * Numeral.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return String.format("%.0f", value);
    }

    /**
     * Numeral.
     *
     * @return evaluate.
     */
    @Override
    public double evaluate() {
        return value;
    }
}
