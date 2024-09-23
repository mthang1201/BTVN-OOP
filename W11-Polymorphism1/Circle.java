import java.awt.*;

/**
 * Circle.
 */
public class Circle extends Shape {
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

    @Override
    public String toString() {
        return "-   Circle[radius=" + radius + ",color=" + color + ",filled=" + filled + "]";
    }
}
