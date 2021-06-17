package levels;

import common.Background;
import common.Utils;
import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import elements.Circle;

import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import static common.Utils.BLOCK_HEIGHT;
import static common.Utils.BLOCK_WIDTH;
import static common.Utils.BORDER_WIDTH;
import static common.Utils.HEIGHT;
import static common.Utils.WIDTH;

/**
 * @author Sharon Weiss
 */
public class ForthLevel extends Level {
    private static final int BALL_NUM = 2;
    private Sprite background;
    private Paddle paddle;

    /**
     * forth level constructor.
     */
    public ForthLevel() {
        super();
        this.setLevelName("Forth Level");
        this.paddle = new Paddle(new Rectangle(new Point(340, 580), 200, 30), Utils.generateColor(), 9);
        createBalls();
        createBlocks();
    }

    /**
     * create second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball b1 = new Ball(400, 572, Utils.RADIUS, Utils.generateColor());
            b1.setVelocity(Velocity.fromAngleAndSpeed(40, 9));
            this.getBallsList().add(b1);
            Ball b2 = new Ball(400, 572, Utils.RADIUS, Utils.generateColor());
            b2.setVelocity(Velocity.fromAngleAndSpeed(0, 9));
            this.getBallsList().add(b2);
            Ball b3 = new Ball(400, 572, Utils.RADIUS, Utils.generateColor());
            b3.setVelocity(Velocity.fromAngleAndSpeed(-40, 9));
            this.getBallsList().add(b3);
        }
    }

    /**
     * create second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < 6; i++) {
            Color color = Utils.generateColor();
            for (int k = 1; k < 16; k++) {
                Rectangle rectangle = new Rectangle(new Point(WIDTH - ((k) * BLOCK_WIDTH) - BORDER_WIDTH,
                        i * BLOCK_HEIGHT + 200), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle);
                block.setColor(color);
                this.blocks().add(block);
            }
        }
    }

    /**
     * @return sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(100, 80), 24, Utils.LIGHT_GRAY, true);
        Circle c2 = new Circle(new Point(120, 100), 29, Utils.LIGHT_GRAY, true);
        Circle c3 = new Circle(new Point(140, 60), 29, Utils.STAR, true);
        Circle c4 = new Circle(new Point(160, 100), 26, Utils.LIGHT_GRAY, true);
        Circle c5 = new Circle(new Point(180, 80), 28, Utils.LIGHT_GRAY, true);
        Circle c6 = new Circle(new Point(180, 80), 29, Utils.LIGHT_GRAY, true);
        Circle c7 = new Circle(new Point(200, 100), 30, Utils.STAR, true);
        Circle c8 = new Circle(new Point(220, 60), 25, Utils.LIGHT_GRAY, true);
        Circle c9 = new Circle(new Point(240, 100), 26, Utils.LIGHT_GRAY, true);
        Circle c10 = new Circle(new Point(260, 80), 29, Utils.STAR, true);
        Circle c11 = new Circle(new Point(270, 80), 20, Utils.LIGHT_GRAY, true);
        Circle c12 = new Circle(new Point(290, 100), 25, Utils.LIGHT_GRAY, true);
        Circle c13 = new Circle(new Point(310, 60), 26, Utils.LIGHT_GRAY, true);
        Circle c14 = new Circle(new Point(330, 100), 28, Utils.STAR, true);
        Circle c15 = new Circle(new Point(350, 80), 29, Utils.LIGHT_GRAY, true);
        Circle c16 = new Circle(new Point(600, 110), 50, Utils.MOON, true);
        Circle c17 = new Circle(new Point(630, 110), 50, Utils.NIGHT_SKY, true);
        sprites.add(c1);
        sprites.add(c2);
        sprites.add(c3);
        sprites.add(c4);
        sprites.add(c5);
        sprites.add(c6);
        sprites.add(c7);
        sprites.add(c8);
        sprites.add(c9);
        sprites.add(c10);
        sprites.add(c11);
        sprites.add(c12);
        sprites.add(c13);
        sprites.add(c14);
        sprites.add(c15);
        sprites.add(c16);
        sprites.add(c17);

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            sprites.add(new Circle(new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT)), 1, Utils.STAR, true));
        }
        return new Background(Utils.NIGHT_SKY, sprites);
    }

    /**
     * @return paddle's rectangle
     */
    @Override
    public Rectangle getPaddleRectangle() {
        return this.paddle.getRectangle();
    }

    /**
     * @return paddle's color.
     */
    @Override
    public Color getPaddleColor() {
        return this.paddle.getColor();
    }

    /**
     * @return paddle's speed
     */
    @Override
    public int getPaddleSpeed() {
        return this.paddle.getSpeed();
    }

}
