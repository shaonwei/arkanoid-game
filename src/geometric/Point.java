package geometric;

import common.Utils;

/**
 * @author Sharon Weiss
 * 207488321
 * Point object
 */
public class Point {
    private double x;
    private double y;


    /**
     * @param x double x coordinate
     * @param y double y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other Point
     * @return return the distance of this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * @param other Point
     * @return return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.getX()) <= Utils.EPSILON) && (Math.abs(this.y - other.getY()) <= Utils.EPSILON);
    }

    /**
     * @return x coordinate value
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return y coordinate value
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param newX double x coordinate
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * @param newY double y coordinate
     */
    public void setY(double newY) {
        this.y = newY;
    }

    /**
     * @return String of point coordinates
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}