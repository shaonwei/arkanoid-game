package interfaces;

import biuoop.DrawSurface;

/**
 * @author Sharon Weiss
 */
public interface Animation {
    /**
     * @param d DrawSurface
     *          draws on frame on gui.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return true if drawing should stop
     * else return false.
     */
    boolean shouldStop();
}
