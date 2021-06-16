package levels;

import common.Utils;
import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;

import static common.Utils.BLOCK_HEIGHT;
import static common.Utils.BLOCK_WIDTH;
import static common.Utils.BORDER_WIDTH;
import static common.Utils.WIDTH;

/**
 * @author Sharon Weiss
 */
public class ThirdLevel extends Level {
    private static final int BALL_NUM = 2;
    private Sprite background;
    private Paddle paddle;


    /**
     * third level constructor.
     */
    public ThirdLevel() {
        super();
        this.setLevelName("Third Level");
        this.paddle = new Paddle(new Rectangle(new Point(WIDTH / 2 - 60, 580), 120, 30), Utils.generateColor(), 5);
        createBalls();
        createBlocks();
    }

    /**
     * create second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball ball = new Ball(400, 570, Utils.RADIUS, Utils.generateColor());
            ball.setVelocity(Velocity.fromAngleAndSpeed(10 * i - 50, 4));
            this.getBallsList().add(ball);
        }
    }

    /**
     * create second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < 6; i++) {
            Color color = Utils.generateColor();
            for (int k = 1; k < 13 - i; k++) {
                Rectangle rectangle = new Rectangle(new Point(WIDTH - ((k) * BLOCK_WIDTH) - BORDER_WIDTH,
                        i * BLOCK_HEIGHT + 100), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle);
                block.setColor(color);
                this.blocks().add(block);
            }
        }
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
