package levels;

import common.Background;
import common.Utils;
import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.DrawLine;
import elements.Paddle;
import elements.Circle;
import geometric.Line;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;

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
        this.paddle = new Paddle(new Rectangle(new Point(Utils.WIDTH / 2 - 60, 580), 120, 30),
                Utils.generateColor(), 5);
        Ball ball = new Ball(400, 570, Utils.RADIUS, Utils.generateColor());
        ball.setVelocity(new Velocity(0, 3));
        this.getBallsList().add(ball);
        Block block = new Block(new Rectangle(new Point(Utils.WIDTH / 2 - 40, 122), 80, 80));
        block.setColor(new Color(255, 153, 255));
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

    /**
     * @return sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(400, 162), 60, Utils.PINK, false);
        Circle c2 = new Circle(new Point(400, 162), 90, Utils.PINK, false);
        Circle c3 = new Circle(new Point(400, 162), 120, Utils.PINK, false);
        DrawLine l1 = new DrawLine(new Line(400, 182, 400, 302), Utils.PINK);
        DrawLine l2 = new DrawLine(new Line(420, 162, 540, 162), Utils.PINK);
        DrawLine l3 = new DrawLine(new Line(380, 162, 260, 163), Utils.PINK);
        DrawLine l4 = new DrawLine(new Line(400, 142, 400, 22), Utils.PINK);
        sprites.add(c1);
        sprites.add(c2);
        sprites.add(c3);
        sprites.add(l1);
        sprites.add(l2);
        sprites.add(l3);
        sprites.add(l4);
        return new Background(Utils.LIGHT_GREEN, sprites);


    }
}
