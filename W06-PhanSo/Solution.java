public class Solution {
    private int numerator;

    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    public Solution() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Solution(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Solution(int numerator, int denominator) {
        if (denominator == 0) {
            denominator = 1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    public Solution add(Solution other) {
        this.numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    public Solution subtract(Solution other) {
        this.numerator = this.numerator * other.denominator - this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    public Solution multiply(Solution other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    public Solution divide(Solution other) {
        if (other.numerator == 0) {
            return this;
        }
        this.numerator = this.numerator * other.denominator;
        this.denominator = this.denominator * other.numerator;
        return reduce();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Solution other = (Solution) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }
}
