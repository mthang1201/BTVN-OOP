/**
 * Point.
 */
public class Point {
    private double pointX;

    private double pointY;

    /**
     * Point.
     */
    public Point() {
        this.pointX = 0;
        this.pointY = 0;
    }

    /**
     * Point.
     *
     * @param pointX of the point.
     * @param pointY of the point.
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * distance.
     *
     * @param newPoint to currentPoint.
     * @return distance.
     */
    public double distance(Point newPoint) {
        return Math.sqrt(
                Math.pow(pointX - newPoint.getPointX(), 2)
                        + Math.pow(pointY - newPoint.getPointY(), 2)
        );
    }

    /**
     * equals.
     *
     * @param o compare to another object.
     * @return whether equals.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        if (o == this) {
            return true;
        }

        Point point = (Point) o;
        return pointX == point.getPointX() && pointY == point.getPointY();
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
        return "("
                + String.format("%.1f", pointX)
                + ","
                + String.format("%.1f", pointY)
                + ")";
    }
}
