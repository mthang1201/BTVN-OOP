/**
 * Cylinder.
 */
public class Cylinder extends Circle {
    private double height;

    /**
     * Constructor1.
     */
    public Cylinder() {
        super();
    }

    /**
     * Constructor2.
     *
     * @param height Cylinder.
     */
    public Cylinder(double height) {
        this.height = height;
    }

    /**
     * Constructor3.
     *
     * @param radius Cylinder.
     * @param height Cylinder.
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     * Constructor4.
     *
     * @param radius Cylinder.
     * @param height Cylinder.
     * @param color Cylinder.
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
     * getVolume.
     *
     * @return getVolume.
     */
    public double getVolume() {
        return super.getArea() * height;
    }

    /**
     * toString.
     *
     * @return toString.
     */
    public String toString() {
        return "Cylinder[" + super.toString() + "],height=" + height + "]";
    }

    /**
     * getArea.
     *
     * @return getArea.
     */
    @Override
    public double getArea() {
        return 2 * super.getArea() + 2 * PI * getRadius() * height;
    }
}
