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
        this.paddle = new Paddle(new Rectangle(new Point(WIDTH / 2 - 60, 580), 120, 30), Utils.generateColor(), 6);
        createBalls();
        createBlocks();
    }

    /**
     * create second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball ball = new Ball(400, 570, Utils.RADIUS, Utils.generateColor());
            ball.setVelocity(Velocity.fromAngleAndSpeed(10 * i - 50, 6));
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
     * @return sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            sprites.add(new Circle(new Point(50, 80 + i * 50), 20, Color.black, true));
            sprites.add(new Circle(new Point(35, 60 + i * 50), 11, Color.black, true));
            sprites.add(new Circle(new Point(65, 60 + i * 50), 11, Color.black, true));
        }

        return new Background(Utils.LIGHT_GREEN, sprites);

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
