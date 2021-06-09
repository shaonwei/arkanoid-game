package interfaces;

import biuoop.DrawSurface;

/**
 * @author Sharon Weiss
 */
public interface Sprite {
    /**
     * @param d DrawSurface
     *          draw the sprite to the screen
     */

    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
