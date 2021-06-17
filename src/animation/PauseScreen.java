package animation;

import biuoop.DrawSurface;
import common.Utils;
import interfaces.Animation;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * stop animation.
     *
     * @param d DrawSurface
     *          draws on frame on gui.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Utils.generateColor());
        d.drawText(150, 250, "paused press space to continue", 30);
        d.setColor(Color.RED);
        d.fillRectangle(150, 350, 50, 110);
        d.fillRectangle(230, 350, 50, 110);
    }

    /**
     * @return true if drawing should stop
     * else return false.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
