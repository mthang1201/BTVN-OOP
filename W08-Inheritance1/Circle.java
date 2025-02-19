/**
 * Circle.
 */
public class Circle {
    private double radius;

    private String color;

    protected static final double PI = Math.PI;

    /**
     * Constructor1.
     */
    public Circle() {
        radius = 0.0;
    }

    /**
     * Constructor2.
     *
     * @param radius Circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor3.
     *
     * @param radius Circle.
     * @param color Circle.
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * getArea.
     *
     * @return getArea.
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * toString.
     *
     * @return toString
     */
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }
}
