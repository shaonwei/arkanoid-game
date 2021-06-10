package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import common.Utils;
import interfaces.Animation;

/**
 * @author Sharon Weiss
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean isWin;
    private int score;

    /**
     * constructor.
     *
     * @param k KeyboardSensor
     */
    public EndScreen(KeyboardSensor k, boolean isWin, int score) {
        this.keyboard = k;
        this.isWin = isWin;
        this.score = score;
        this.stop = false;
    }

    /**
     * @param d DrawSurface
     *          draws on frame on gui.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Utils.generateColor());
        if (isWin) {
            d.drawText(250, 250, "You Win! Your score is " + this.score, 30);
        } else {
            d.drawText(250, 250, "Game Over. Your score is " + this.score, 30);
        }
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
