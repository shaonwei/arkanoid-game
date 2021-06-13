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

/**
 * @author Sharon Weiss
 */
public class FirstLevel extends Level {
    private Sprite background;
    private Paddle paddle;

    /**
     * first level constructor.
     */
    public FirstLevel() {
        super();
        this.setLevelName("First Level");
        this.paddle = new Paddle(new Rectangle(new Point(Utils.WIDTH / 2 - 60, 580), 120, 30), Utils.generateColor(), 5);
        Ball ball = new Ball(400, 570, Utils.RADIUS, Utils.generateColor());
        ball.setVelocity(new Velocity(0, 3));
        this.getBallsList().add(ball);
        Block block = new Block(new Rectangle(new Point(Utils.WIDTH / 2 - 40, 200), 80, 80));
        block.setColor(Color.red);
        this.blocks().add(block);
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
