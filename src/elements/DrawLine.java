package elements;

import biuoop.DrawSurface;
import geometric.Line;
import interfaces.Sprite;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class DrawLine implements Sprite {
    private Line line;
    private Color color;

    /**
     * constructor.
     *
     * @param line  Line
     * @param color Color
     */
    public DrawLine(Line line, Color color) {
        this.line = line;
        this.color = color;
    }

    /**
     * @param d DrawSurface
     *          draw the sprite to the screen
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.line.start().getX(), (int) this.line.start().getY(), (int) this.line.end().getX(),
                (int) this.line.start().getY());
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
