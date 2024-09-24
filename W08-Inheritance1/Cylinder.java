/**
 * Cylinder.
 */
public class Cylinder extends Circle {
    private double height;

    /**
     *
     */
    public Cylinder() {
        super();
    }

    /**
     *
     * @param height
     */
    public Cylinder(double height) {
        this.height = height;
    }

    /**
     *
     * @param radius
     * @param height
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     *
     * @param radius
     * @param height
     * @param color
     */
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public double getVolume() {
        return super.getArea() * height;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "Cylinder[" + super.toString() + "],height=" + height + "]";
    }

    /**
     *
     * @return
     */
    @Override
    public double getArea() {
        return 2 * super.getArea() + 2 * PI * getRadius() * height;
    }
}
