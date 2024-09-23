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
        width = 0;
        length = 0;
    }

    /**
     * Constructor2.
     * 
     * @param width of the rectangle.
     * @param length of the rectangle.
     */
    public Rectangle(double width, double length) {
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
     *
     * @return area.
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     *
     * @return perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
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
        return true;
    }

    /**
     *
     * @return hashCode.
     */
    public int hashCode() {
        return 0;
    }

    /**
     *
     * @return toString.
     */
    @Override
    public String toString() {
        return "-Rectangle[topLeft=" + topLeft.toString() + ",width=" + String.format("%.1f", width) + ",length=" + String.format("%.1f", length) + ",color=" + color + ",filled=" + filled + "]";
    }
}
