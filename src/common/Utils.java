package common;

import geometric.Point;

import java.awt.Color;
import java.util.Random;

/**
 * @author Sharon Weiss
 */
public class Utils {
    public static final int RGB = 255;
    public static final int FIXED_RADIUS = 50;
    public static final int START_POINT = 320;
    public static final int RANGE = 100;
    public static final double EPSILON = Math.pow(10, -15);
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int BORDER_WIDTH = 20;
    public static final int BLOCK_WIDTH = 50;
    public static final int BLOCK_HEIGHT = 20;
    public static final int FRAMES_PER_SECOND = 60;
    public static final int RADIUS = 7;


    /**
     * @return new random color
     */
    public static Color generateColor() {
        Random rand = new Random();
        int r = rand.nextInt(RGB);
        int g = rand.nextInt(RGB);
        int b = rand.nextInt(RGB);
        return new Color(r, g, b);
    }

    /**
     * @return random point
     */
    public static Point generatePoint() {
        //todo: test
        Random rand = new Random();
        int x = 340/*rand.nextInt(START_POINT) + RANGE*/;
        int y = 550/*rand.nextInt(START_POINT) + RANGE*/;
        return new Point(x, y);
    }

    /**
     * @return new velocity
     */
    public static Velocity generateVelocity() {
        /*if (true) {*/
        return new Velocity(-2, 3);

        /*if (radius >= FIXED_RADIUS) {
            return new Velocity(0.5, 0.5);
        } else {
            return Velocity.fromAngleAndSpeed((double) (FIXED_RADIUS - radius) / 2,
                    (double) (FIXED_RADIUS - radius) / 2);
        }*/
    }
}
