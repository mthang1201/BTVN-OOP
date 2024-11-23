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
        super(color, filled);
        this.topLeft = new Point();
        this.width = width;
        this.length = length;
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
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
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
        if (o instanceof Rectangle) {
            Rectangle another = (Rectangle) o;
            return Math.abs(this.width - another.getWidth())
                    <= 0.001
                    && Math.abs(this.length - another.getLength())
                    <= 0.001
                    && this.topLeft.equals(another.getTopLeft());
        }
        return false;
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
