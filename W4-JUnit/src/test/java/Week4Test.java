import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Week4Test {
    /**
     * TestMax2Int1.
     */
    @Test
    public void testMax2Int1() {
        int a = 5;
        int b = 8;
        assertEquals(8, Week4.max2Int(a, b));
    }

    /**
     * TestMax2Int2.
     */
    @Test
    public void testMax2Int2() {
        int a = 55;
        int b = 8;
        assertEquals(55, Week4.max2Int(a, b));
    }

    /**
     * TestMax2Int3.
     */
    @Test
    public void testMax2Int3() {
        int a = 533333333;
        int b = 8;
        assertEquals(533333333, Week4.max2Int(a, b));
    }

    /**
     * TestMax2Int4.
     */
    @Test
    public void testMax2Int4() {
        int a = 5;
        int b = -8;
        assertEquals(5, Week4.max2Int(a, b));
    }

    /**
     * TestMax2Int5.
     */
    @Test
    public void testMax2Int5() {
        int a = 0;
        int b = 0;
        assertEquals(0, Week4.max2Int(a, b));
    }

    /**
     * TestMinArray1.
     */
    @Test
    public void testMinArray1() {
        int[] array = {5, 9, 34, 2, 7, 23};
        assertEquals(2, Week4.minArray(array));
    }

    /**
     * TestMinArray2.
     */
    @Test
    public void testMinArray2() {
        int[] array = {5, 9, 34, 2, 7, 23, 3333, 0};
        assertEquals(0, Week4.minArray(array));
    }

    /**
     * TestMinArray3.
     */
    @Test
    public void testMinArray3() {
        int[] array = {5, 9, 34, 2, 7, 23, -8};
        assertEquals(-8, Week4.minArray(array));
    }

    /**
     * TestMinArray4.
     */
    @Test
    public void testMinArray4() {
        int[] array = {5, 9, 34, 2, 7, 23, 0, -100, 333};
        assertEquals(-100, Week4.minArray(array));
    }

    /**
     * TestMinArray5.
     */
    @Test
    public void testMinArray5() {
        int[] array = {5, 9, 34, 2, 7, 23, };
        assertEquals(2, Week4.minArray(array));
    }

    /**
     * TestCalculateBMI1.
     */
    @Test
    public void testCalculateBmi1() {
        double weight = 25;
        double height = 1.23;
        assertEquals("Thiếu cân", Week4.calculateBMI(weight, height));
    }

    /**
     * TestCalculateBMI2.
     */
    @Test
    public void testCalculateBmi2() {
        double weight = 75;
        double height = 1.78;
        assertEquals("Thừa cân", Week4.calculateBMI(weight, height));
    }

    /**
     * TestCalculateBMI3.
     */
    @Test
    public void testCalculateBmi3() {
        double weight = 45;
        double height = 0;
        assertEquals("BMI Error", Week4.calculateBMI(weight, height));
    }

    /**
     * TestCalculateBMI4.
     */
    @Test
    public void testCalculateBmi4() {
        double weight = 0;
        double height = 1.23;
        assertEquals("BMI Error", Week4.calculateBMI(weight, height));
    }

    /**
     * TestCalculateBMI5.
     */
    @Test
    public void testCalculateBmi5() {
        double weight = 168;
        double height = 1.68;
        assertEquals("Béo phì", Week4.calculateBMI(weight, height));
    }
} 