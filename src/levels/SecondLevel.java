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

import static game.GameLevel.BLOCK_HEIGHT;
import static game.GameLevel.BLOCK_WIDTH;
import static game.GameLevel.BORDER_WIDTH;

/**
 * @author Sharon Weiss
 */
public class SecondLevel extends Level {
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
        for (int i = 0; i < 13; i++) {
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
        for (int i = 0; i < 10; i++) {
            Ball ball = new Ball(250 + i * 30, 570, 10, Utils.generateColor());
            ball.setVelocity(new Velocity(0, 3));
            this.getBallsList().add(ball);
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
