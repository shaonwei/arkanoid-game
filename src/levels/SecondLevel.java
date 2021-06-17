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

import static game.GameLevel.BLOCK_HEIGHT;
import static game.GameLevel.BLOCK_WIDTH;
import static game.GameLevel.BORDER_WIDTH;

/**
 * @author Sharon Weiss
 */
public class SecondLevel extends Level {
    private static final int BALL_NUM = 12;
    private static final int BLOCK_NUM = 13;
    private Sprite background;
    private Paddle paddle;

    /**
     * second level constructor.
     */
    public SecondLevel() {
        super();
        this.setLevelName("Second Level");
        this.paddle = new Paddle(new Rectangle(new Point(200, 580), 400, 30), Utils.generateColor(), 5);
        createBlocks();
        createBalls();
    }

    /**
     * create second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < BLOCK_NUM; i++) {
            Rectangle rectangle = new Rectangle(new Point(BORDER_WIDTH + (i * BLOCK_WIDTH),
                    BLOCK_HEIGHT + 300), BLOCK_WIDTH, BLOCK_HEIGHT);
            Block block = new Block(rectangle);
            block.setColor(Utils.generateColor());
            this.blocks().add(block);
        }
    }

    /**
     * create second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball ball = new Ball(400, 570, Utils.RADIUS, Utils.generateColor());
            ball.setVelocity(Velocity.fromAngleAndSpeed(10 * i - 50, 5));
            this.getBallsList().add(ball);
        }
    }

    /**
     * @return sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(400, 600), 500, Utils.LIGHT_PINK, true);
        Circle c2 = new Circle(new Point(400, 600), 450, Utils.LIGHT_ORANGE, true);
        Circle c3 = new Circle(new Point(400, 600), 400, Utils.BANANA, true);
        Circle c4 = new Circle(new Point(400, 600), 350, Utils.LIGHT_GREEN, true);
        Circle c5 = new Circle(new Point(400, 600), 300, Utils.LIGHT_BLUE, true);
        Circle c6 = new Circle(new Point(400, 600), 250, Utils.LIGHT_PURPLE, true);

        sprites.add(c1);
        sprites.add(c2);
        sprites.add(c3);
        sprites.add(c4);
        sprites.add(c5);
        sprites.add(c6);
        return new Background(Color.white, sprites);
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
