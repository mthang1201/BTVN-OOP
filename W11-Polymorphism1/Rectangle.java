/**
 * Rectangle.
 */
public class Rectangle extends Shape {
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

    @Override
    public String toString() {
        return "-   Rectangle[width=" + width + ",length=" + length + ",color=" + color + ",filled=" + filled + "]";
    }
}
