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
    public static final Color LIGHT_PINK = new Color(255, 219, 219);
    public static final Color LIGHT_ORANGE = new Color(255, 238, 226);
    public static final Color BANANA = new Color(252, 250, 222);
    public static final Color LIGHT_GREEN = new Color(230, 255, 242);
    public static final Color LIGHT_BLUE = new Color(223, 242, 253);
    public static final Color LIGHT_PURPLE = new Color(227, 227, 255);
    public static final Color PINK = new Color(255, 102, 255);
    public static final Color LIGHT_GRAY = new Color(242, 242, 242);
    public static final Color NIGHT_SKY = new Color(0, 51, 153);
    public static final Color MOON = new Color(242, 242, 242);
    public static final Color STAR = new Color(250, 250, 250);


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
        Random rand = new Random();
        int x = rand.nextInt(START_POINT) + RANGE;
        int y = rand.nextInt(START_POINT) + RANGE;
        return new Point(x, y);
    }

    /**
     * @return new velocity
     */
    public static Velocity generateVelocity() {
        return new Velocity(-2, 3);
    }
}
