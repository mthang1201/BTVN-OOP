/**
 * Week 4.
 */
public class Week4 {
    /**
     * Find max between two numbers.
     *
     * @param a first integer.
     * @param b second integer.
     * @return max of the two.
     */
    public static int max2Int(int a, int b) {
        // Tim gia tri lon nhat cua hai so nguyen
        if (a < b) {
            return b;
        }

        return a;
    }

    /**
     * Find minimum in the array.
     *
     * @param array given array.
     * @return min number of the array.
     */
    public static int minArray(int[] array) {
        // Tim gia tri nho nhat cua 1 mang so nguyen
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }

        return min;
    }

    /**
     * Calculate bmi index based on weight and height.
     *
     * @param weight of the person.
     * @param height of the person.
     * @return bmi index of the person.
     */
    public static String calculateBMI(double weight, double height) {
        // Tinh BMI
        String res;
        if (height == 0) {
            return "BMI Error";
        }

        double bmi = (double) Math.round((weight / (height * height)) * 10) / 10;

        if (bmi <= 0) {
            res = "BMI Error";
        } else if (bmi < 18.5) {
            res = "Thiếu cân";
        } else if (bmi <= 22.9) {
            res = "Bình thường";
        } else if (bmi <= 24.9) {
            res = "Thừa cân";
        } else {
            res = "Béo phì";
        }

        return res;
    }
}
 