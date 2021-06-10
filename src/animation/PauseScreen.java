package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import common.Utils;
import interfaces.Animation;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     *
     * @param k KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
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
        d.drawText(250, 250, "paused -- press space to continue", 30);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
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
