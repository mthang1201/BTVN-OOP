/**
 * Circle.
 */
public class Circle extends Shape {
    protected Point center;

    protected double radius;

    /**
     * Constructor1.
     */
    public Circle() {
        this.radius = 0.0;
    }

    /**
     * Constructor2.
     *
     * @param radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor3.
     *
     * @param radius of the circle.
     * @param color of the circle.
     * @param filled of the circle.
     */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor4.
     *
     * @param center of the circle.
     * @param radius of the circle.
     * @param color of the circle.
     * @param filled of the circle.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     *
     * @return area.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     *
     * @return perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "-Circle[center=" + center.toString() + "radius=" + String.format("%.1f", radius) + ",color=" + color + ",filled=" + filled + "]";
    }

    /**
     *
     * @param o compare to another object.
     * @return whether equals.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }
        if (o == this) {
            return true;
        }

        Circle c = (Circle) o;
        return radius == c.radius && color.equals(c.color) && filled == c.filled;
    }

    /**
     *
     * @return hashCode.
     */
    public int hashCode() {
        return 0;
    }
}
