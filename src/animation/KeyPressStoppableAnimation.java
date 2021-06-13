package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * @author Sharon Weiss
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param sensor    KeyboardSensor
     * @param key       String
     * @param animation Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;

    }

    /**
     * @param d DrawSurface
     *          draws on frame on gui.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.stop = true;
        }
        if (this.isAlreadyPressed) {
            this.isAlreadyPressed = false;
        }
       /* this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            if (this.isAlreadyPressed) {
                this.stop = false;
            } else {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }*/
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
