package common;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Sharon Weiss
 */
public class Background implements Sprite {

    private Color background;
    private ArrayList<Sprite> sprites;

    /**
     * constructor.
     *
     * @param color   Color
     * @param sprites ArrayList<Sprite>
     */
    public Background(Color color, ArrayList<Sprite> sprites) {
        this.background = color;
        this.sprites = sprites;
    }

    /**
     * @param d DrawSurface
     *          draw the sprite to the screen
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.background);
        d.fillRectangle(0, 0, Utils.WIDTH, Utils.HEIGHT);
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
