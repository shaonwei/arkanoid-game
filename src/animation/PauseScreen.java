package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import common.Utils;
import interfaces.Animation;


/**
 * @author Sharon Weiss
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor.
     *
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
        d.drawText(250, 250, "paused press space to continue", 30);
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
