package geometric;

/**
 * @author Sharon Weiss
 * 207488321
 * line equasion object
 */
public class GeometryLine {
    private double a;
    private double b;

    /**
     * GeometryLine constructor.
     *
     * @param a double- slope
     * @param b double - free parameter
     */
    public GeometryLine(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * GeometryLine constructor.
     *
     * @param point Point on line
     * @param slope slope of line
     */
    public GeometryLine(Point point, double slope) {
        this.a = slope;
        this.b = -(slope * point.getX() - point.getY());
    }

    /**
     * @param other {@link GeometryLine}
     * @return double x coordinate of intersection
     */
    public double xIntersecting(GeometryLine other) {
        return (other.b - this.b) / (this.a - other.a);
    }

    /**
     * @param x double
     * @return y coordinate of intersection
     */
    public double getYByX(double x) {
        return (this.a * x + b);
    }

    /**
     * @param x double coordinate
     * @param y double coordinate
     * @return if (x,y) is on line
     */
    public boolean pointOnLine(double x, double y) {
        return y == this.a * x + b;
    }

    /**
     * @return slope of line
     */
    public double getA() {
        return a;
    }

    /**
     * @return free parameter of line
     */
    public double getB() {
        return b;
    }

    /**
     * @param slope double slope
     */
    public void setA(double slope) {
        this.a = slope;
    }

    /**
     * @param param double free parameter of line
     */
    public void setB(double param) {
        this.b = param;
    }
}
