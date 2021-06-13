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
public class ForthLevel extends Level {
    private static final int BALL_NUM = 10;
    private Sprite background;
    private Paddle paddle;

    /**
     * forth level constructor.
     */
    public ForthLevel() {
        super();
        this.setLevelName("Forth Level");
        this.paddle = new Paddle(new Rectangle(new Point(340, 580), 220, 30), Utils.generateColor(), 5);
        createBalls();
        createBlocks();
    }

    /**
     * create second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball ball = new Ball(360 + i * 5, 572, Utils.RADIUS, Utils.generateColor());
            ball.setVelocity(new Velocity(4, 1.5));
            this.getBallsList().add(ball);
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
