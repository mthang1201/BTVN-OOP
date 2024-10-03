public class Solution {
    private int numerator;

    private int denominator;

    /**
     * GetNumerator.
     *
     * @return numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * SetNumerator.
     *
     * @param numerator setNumerator.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * GetDenominator.
     *
     * @return denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * SetDenominator.
     *
     * @param denominator setDenominator.
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    /**
     * Constructor1.
     */
    public Solution() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Constructor2.
     *
     * @param numerator of solution.
     */
    public Solution(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Constructor3.
     *
     * @param numerator of solution.
     * @param denominator of solution.
     */
    public Solution(int numerator, int denominator) {
        if (denominator == 0) {
            denominator = 1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * GCD.
     *
     * @param a first number.
     * @param b second number.
     * @return gcd.
     */
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Reduce.
     *
     * @return reduce.
     */
    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    /**
     * Add.
     *
     * @param other solution.
     * @return add.
     */
    public Solution add(Solution other) {
        this.numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    /**
     * Subtract.
     *
     * @param other solution.
     * @return subtract.
     */
    public Solution subtract(Solution other) {
        this.numerator = this.numerator * other.denominator - this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    /**
     * Multiply.
     *
     * @param other solution.
     * @return multiply.
     */
    public Solution multiply(Solution other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    /**
     * Divide.
     *
     * @param other solution.
     * @return divide.
     */
    public Solution divide(Solution other) {
        if (other.numerator == 0) {
            return this;
        }
        this.numerator = this.numerator * other.denominator;
        this.denominator = this.denominator * other.numerator;
        return reduce();
    }

    /**
     * Equals.
     *
     * @param obj of others.
     * @return if equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Solution other = (Solution) obj;
        ((Solution) obj).reduce();
        reduce();
        return numerator == other.numerator && denominator == other.denominator;
    }

    public static void main(String[] args) {
        // Create some Solution instances
        Solution sol1 = new Solution(1, 2);
        Solution sol2 = new Solution(1, 3);

        // Demonstrate addition
        Solution resultAdd = sol1.add(sol2);
        System.out.println("Addition: " + resultAdd.getNumerator() + "/" + resultAdd.getDenominator());

        // Demonstrate subtraction
        Solution resultSubtract = sol1.subtract(sol2);
        System.out.println("Subtraction: " + resultSubtract.getNumerator() + "/" + resultSubtract.getDenominator());

        // Demonstrate multiplication
        Solution resultMultiply = sol1.multiply(sol2);
        System.out.println("Multiplication: " + resultMultiply.getNumerator() + "/" + resultMultiply.getDenominator());

        // Demonstrate division
        Solution resultDivide = sol1.divide(sol2);
        System.out.println("Division: " + resultDivide.getNumerator() + "/" + resultDivide.getDenominator());

        // Demonstrate reduction
        Solution sol3 = new Solution(6, 8);
        Solution resultReduce = sol3.reduce();
        System.out.println("Reduced: " + resultReduce.getNumerator() + "/" + resultReduce.getDenominator());

        // Demonstrate equality
        Solution sol4 = new Solution(2, 4);
//        sol4.reduce();
        System.out.println("sol1 equals sol4? " + sol1.equals(sol4));
    }
}
