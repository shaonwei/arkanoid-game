package geometric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon Weiss
 */
public class Rectangle {
    private Point upperLeft;
    private int width;
    private int height;

    /**
     * rectangle constructor.
     *
     * @param upperLeft Point
     * @param width     double
     * @param height    double
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = (int) width;
        this.height = (int) height;
    }

    /**
     * @param line Line
     * @return list of points where line intersects with rectangle
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();
        Point topRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point bottomRight = new Point(topRight.getX(), this.upperLeft.getY() + this.height);
        Point bottomLeft = new Point(this.upperLeft.getX(), bottomRight.getY());
        Line topLine = new Line(this.upperLeft, topRight);
        Line bottomLine = new Line(bottomRight, bottomLeft);
        Line rightLine = new Line(bottomRight, topRight);
        Line leftLine = new Line(bottomLeft, this.upperLeft);
        addToList(list, line, topLine);
        addToList(list, line, bottomLine);
        addToList(list, line, rightLine);
        addToList(list, line, leftLine);
        return list;
    }

    /**
     * @param list  List<Point>
     * @param line  Line
     * @param line2 Line
     *              add intersection poins of 2 line to list
     */
    private void addToList(List<Point> list, Line line, Line line2) {
        Point instPoint = line2.intersectionWith(line);
        if (instPoint != null) {
            list.add(instPoint);
        }
    }

    /**
     * @return rectangle width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return rectangle height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return upper left Point
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @param u Point setter
     */
    public void setUpperLeft(Point u) {
        this.upperLeft = u;
    }

    /**
     * @param w double setter
     */
    public void setWidth(double w) {
        this.width = (int) w;
    }

    /**
     * @param h double setter
     */
    public void setHeight(double h) {
        this.height = (int) h;
    }
}
