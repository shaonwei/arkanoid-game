package geometric;

import java.util.List;

/**
 * @author Sharon Weiss
 * 207488321
 * Line object
 */
public class Line {
    private Point start;
    private Point end;
    private double slope;


    /**
     * constructor.
     *
     * @param start Point
     * @param end   Point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.slope = this.calculateSlope();
    }

    /**
     * @param x1 double- x coordinate start point
     * @param y1 double- y coordinate start point
     * @param x2 double- x coordinate end point
     * @param y2 double- y coordinate end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.slope = this.calculateSlope();
    }

    /**
     * @return Line slope
     */
    public double getSlope() {
        return slope;
    }

    /**
     * set slope to calculated slope.
     */
    public void setSlope() {
        this.slope = this.calculateSlope();
    }

    /**
     * @return length of line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * @return middle Point of line
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * @param other Line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //no slope
        if (Double.isInfinite(this.getSlope())) {
            return infinitySlope(this, other);
        } else if (Double.isInfinite(other.getSlope())) {
            return infinitySlope(other, this);
        } else {
            GeometryLine l1 = new GeometryLine(this.start, this.slope);
            GeometryLine l2 = new GeometryLine(other.start(), other.getSlope());
            double intersectionX = l1.xIntersecting(l2);
            double intersectionY = l1.getYByX(intersectionX);
            return this.pointOnLine(intersectionX, intersectionY) && other.pointOnLine(intersectionX, intersectionY);
        }
    }

    /**
     * @param other Line
     * @return the intersection point if the lines intersect, and null otherwise
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            double intersectionX;
            double intersectionY;
            GeometryLine l1 = new GeometryLine(this.start, this.slope);
            GeometryLine l2 = new GeometryLine(other.start(), other.getSlope());
            intersectionX = l1.xIntersecting(l2);
            if (Double.isInfinite(this.getSlope())) {
                intersectionX = this.start.getX();
                intersectionY = l2.getYByX(intersectionX);
            } else if (Double.isInfinite(other.getSlope())) {
                intersectionX = other.start().getX();
                intersectionY = l1.getYByX(intersectionX);
            } else {
                intersectionY = l1.getYByX(intersectionX);
            }
            return new Point(intersectionX, intersectionY);
        }
        return null;
    }

    /**
     * @param other Line
     * @return return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.calculateSlope() == other.calculateSlope()) {
            return (this.start.equals(other.start()) && this.end.equals(other.end()))
                    || (this.start.equals(other.end()) && this.end.equals(other.start()));
        }
        return false;
    }

    /**
     * @param x coordinate double
     * @param y coordinate double
     * @return true if coordinates on line false otherwise
     */
    public boolean pointOnLine(double x, double y) {
        if ((x <= this.start.getX() && x >= this.end.getX()) || (x >= this.start.getX() && x <= this.end.getX())) {
            return (y <= this.start.getY() && y >= this.end.getY()) || (y > this.start.getY() && y <= this.end.getY());
        }
        return false;
    }

    /**
     * @param rect Rectangle
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        int indexMin = 0;
        List<Point> list = rect.intersectionPoints(this);
        if (list.size() == 0) {
            return null;
        } else {
            double min = this.start.distance(list.get(indexMin));
            for (int i = 1; i < list.size(); i++) {
                double distance = this.start.distance(list.get(i));
                if (distance < min) {
                    min = distance;
                    indexMin = i;
                }
            }
        }
        return list.get(indexMin);
    }

    /**
     * @return slope of line
     */
    private double calculateSlope() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * @param line1 Line
     * @param line2 Line
     * @return true if line2 intersect with line1 with infinity slope
     */
    private static boolean infinitySlope(Line line1, Line line2) {
        if ((line2.end().getX() <= line1.start().getX() && line1.start().getX() <= line2.start().getX())
                || (line2.end.getX() >= line1.start.getX() && line1.start.getX() >= line2.start().getX())) {
            GeometryLine l2 = new GeometryLine(line2.start(), line2.getSlope());
            return infinitySlopeIntersect(line1, l2);
        }
        return false;
    }

    /**
     * @param l1 Line
     * @param l2 GeometryLine
     * @return true l1 and l2 intersecting false otherwise
     */
    private static boolean infinitySlopeIntersect(Line l1, GeometryLine l2) {
        double l2y = l2.getYByX(l1.start().getX());
        return l2y >= Math.min(l1.start().getY(), l1.end().getY()) && l2y <= Math.max(l1.start().getY(),
                l1.end().getY());
    }
}