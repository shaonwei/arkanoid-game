package common;

import geometric.Point;

/**
 * @author Sharon Weiss
 * 207488321
 * Velocity object
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * @param dx double
     * @param dy double
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @param newDX double x speed
     */
    public void setDx(double newDX) {
        this.dx = newDX;
    }

    /**
     * @param newDY double y speed
     */
    public void setDy(double newDY) {
        this.dy = newDY;
    }

    /**
     * @return x speed
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return y speed
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * @param p Point
     * @return Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }

    /**
     * @return double speed
     */
    public double getSpeedFromVelocity() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * @param angle double
     * @param speed double
     * @return calculated velocity by angle and speed
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy = Math.cos(angle * Math.PI / 180) * speed;
        double dx = Math.sin(angle * Math.PI / 180) * speed;
        return new Velocity(dx, -dy);
    }

    /**
     * @return String of velocity details
     */
    @Override
    public String toString() {
        return "Velocity{" + "dx=" + dx + ", dy=" + dy + '}';
    }
}
