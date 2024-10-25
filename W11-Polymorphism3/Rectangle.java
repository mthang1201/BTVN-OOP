import java.awt.Graphics;
import java.awt.Color;

/**
 * Rectangle.
 */
public class Rectangle extends Shape {
    protected Point topLeft;

    protected double width;

    protected double length;

    /**
     * Constructor1.
     */
    public Rectangle() {
        super();
        this.topLeft = new Point();
        this.width = 0;
        this.length = 0;
    }

    /**
     * Constructor2.
     * 
     * @param width of the rectangle.
     * @param length of the rectangle.
     */
    public Rectangle(double width, double length) {
        super();
        this.topLeft = new Point();
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor3.
     * 
     * @param width of the rectangle.
     * @param length of the rectangle.
     * @param color of the rectangle.
     * @param filled of the rectangle.
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        this.topLeft = new Point();
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor4.
     *
     * @param topLeft of the rectangle.
     * @param width of the rectangle.
     * @param length of the rectangle.
     * @param color of the rectangle.
     * @param filled of the rectangle.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * move.
     */
    @Override
    public void move() {
        double newX = topLeft.getPointX() + velocity.getPointX();
        double newY = topLeft.getPointY() + velocity.getPointY();

        if (newX < 0 || newX >= App.SCREEN_WIDTH - width) {
            velocity.setPointX(velocity.getPointX() * -1.0);

            newX = topLeft.getPointX() + velocity.getPointX();
        }

        if (newY < 0 || newY >= App.SCREEN_LENGTH - length) {
            velocity.setPointY(velocity.getPointY() * -1.0);

            newY = topLeft.getPointY() + velocity.getPointY();
        }

        topLeft.setPointX(newX);
        topLeft.setPointY(newX);
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
            graphics.fillRect((int) topLeft.getPointX(), (int) topLeft.getPointY(), (int) width, (int) length);
        } else {
            graphics.drawRect((int) topLeft.getPointX(), (int) topLeft.getPointY(), (int) width, (int) length);
        }
    }

    /**
     * getArea.
     *
     * @return area.
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * getPerimeter.
     *
     * @return perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * equals.
     *
     * @param o compare to another object.
     * @return whether equals.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }
        if (o == this) {
            return true;
        }

        Rectangle r = (Rectangle) o;
        return topLeft.equals(r.topLeft)
                && width == r.width
                && length == r.length
                && color.equals(r.color)
                && filled == r.filled;
    }

    /**
     * hashCode.
     *
     * @return hashCode.
     */
    public int hashCode() {
        return 0;
    }

    /**
     * toString.
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "Rectangle[topLeft="
                + topLeft.toString()
                + ",width="
                + String.format("%.1f", width)
                + ",length="
                + String.format("%.1f", length)
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}