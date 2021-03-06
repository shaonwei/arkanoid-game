package animation;

import biuoop.DrawSurface;
import common.SpriteCollection;

import interfaces.Animation;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class CountdownAnimation implements Animation {
    private boolean isRunning;
    private long numOfMillSec;
    private int initialCountFrom;
    private SpriteCollection gameScreen;
    private long initialTime;

    /**
     * constructor.
     *
     * @param numOfSeconds double
     * @param countFrom    int
     * @param gameScreen   SpriteCollection
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfMillSec = (long) numOfSeconds * 1000;
        this.initialCountFrom = countFrom;
        this.gameScreen = gameScreen;
        this.isRunning = true;
        this.initialTime = System.currentTimeMillis();
    }

    /**
     * @param d DrawSurface
     *          counts before game start- draw on frame on gui.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.initialCountFrom == 1) {
            this.isRunning = false;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.pink);
        d.drawText(400, 250, String.valueOf(this.initialCountFrom), 45);
        if (System.currentTimeMillis() - this.initialTime > this.numOfMillSec / this.initialCountFrom) {
            this.initialCountFrom--;
        }
    }

    /**
     * @return true if drawing should stop
     * else return false.
     */
    @Override
    public boolean shouldStop() {
        return !this.isRunning;
    }
}
