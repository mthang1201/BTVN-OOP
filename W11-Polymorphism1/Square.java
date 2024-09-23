/**
 * Square.
 */
public class Square extends Rectangle {
    /**
     * Constructor1.
     */
    public Square() {}

    /**
     * Constructor2.
     * 
     * @param side of the square.
     */
    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Constructor3.
     * 
     * @param side of the square.
     * @param color of the square.
     * @param filled of the square.
     */
    public Square(double side, String color, boolean filled) {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }
    
    public double getSide() {
        return width;
    }
    
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
        this.length = width;
    }

    @Override
    public void setLength(double length) {
        this.width = length;
        this.length = length;
    }

    @Override
    public String toString() {
        return "-   Square[side=" + width + ",color=" + color + ",filled=" + filled + "]";
    }
}
