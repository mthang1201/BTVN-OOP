import java.awt.*;

/**
 * Shape.
 */
public abstract class Shape {
    protected Point velocity = RandomGenerator.getInstance().getVelocity();

    protected String color;

    protected boolean filled;

    /**
     * Constructor1.
     */
    public Shape() {
        this.color = "";
        this.filled = false;
    }

    /**
     * Constructor2.
     *
     * @param color of the shape.
     * @param filled of the shape.
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract void move();

    public abstract void draw(Graphics graphics);

    public abstract double getArea();

    public abstract double getPerimeter();

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "-Shape[color=" + color + ",filled=" + filled + "]";
    }
}
