import java.awt.Graphics;
import java.awt.Color;

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
        super();
        this.center = new Point();
        this.radius = 0.0;
    }

    /**
     * Constructor2.
     *
     * @param radius of the circle.
     */
    public Circle(double radius) {
        super();
        this.center = new Point();
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
        this.center = new Point();
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
     * move.
     */
    @Override
    public void move() {
        double newX = center.getPointX() + velocity.getPointX();
        double newY = center.getPointY() + velocity.getPointY();

        if (newX < 0 || newX >= App.SCREEN_WIDTH - radius) {
            velocity.setPointX(velocity.getPointX() * -1.0);

            newX = center.getPointX() + velocity.getPointX();
        }

        if (newY < 0 || newY >= App.SCREEN_LENGTH - radius) {
            velocity.setPointY(velocity.getPointY() * -1.0);

            newY = center.getPointY() + velocity.getPointY();
        }

        center.setPointX(newX);
        center.setPointY(newX);
    }

    /**
     * draw.
     *
     * @param graphics draw.
     */
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.decode(color));
        if (filled) {
            graphics.fillOval((int) center.getPointX(), (int) center.getPointY(), (int) radius, (int) radius);
        } else {
            graphics.drawOval((int) center.getPointX(), (int) center.getPointY(), (int) radius, (int) radius);
        }
    }

    /**
     * getArea.
     *
     * @return area.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * getPerimeter.
     *
     * @return perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * toString.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "Circle[center="
                + center.toString()
                + ",radius="
                + String.format("%.1f", radius)
                + ",color=" + color + ",filled="
                + filled + "]";
    }

    /**
     * equals.
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
        return center.equals(c.center)
                && radius == c.radius
                && color.equals(c.color)
                && filled == c.filled;
    }

    /**
     * hashCode.
     *
     * @return hashCode.
     */
    public int hashCode() {
        return 0;
    }
}
