package elements;

import biuoop.DrawSurface;
import geometric.Point;
import interfaces.Sprite;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class Circle implements Sprite {

    private Point center;
    private int radius;
    private Color color;
    private boolean isFill;

    /**
     * @param center Point
     * @param radius int
     * @param color Color
     * @param isFill boolean
     */
    public Circle(Point center, int radius, Color color, boolean isFill) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.isFill = isFill;
    }

    /**
     * @param d DrawSurface
     *          draw the sprite to the screen
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        if (isFill) {
            d.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        } else {
            d.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);

        }
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
