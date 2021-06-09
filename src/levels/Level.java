package levels;

import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import geometric.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon Weiss
 */
public abstract class Level implements LevelInformation {
    private List<Ball> ballList;
    private List<Block> blocks;
    private String levelName;
    private Sprite background;
    private Paddle paddle;

    public Level() {
        this.ballList = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.levelName = " ";
    }

    /**
     * @return int- number of balls
     */
    @Override
    public int numberOfBalls() {
        return this.ballList.size();
    }

    /**
     * @return list of velocities of balls
     * The initial velocity of each ball
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (Ball ball : this.ballList) {
            velocities.add(ball.getVelocity());
        }
        return velocities;
    }

    /**
     * @return paddle speed
     */
    @Override
    public int paddleSpeed() {
        return this.paddle.getSpeed();
    }

    /**
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return this.paddle.getRectangle().getWidth();
    }

    /**
     * @return level name will be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return this.levelName;
    }

    /**
     * @return sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * @return list of blocks of the level
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * @return Number of blocks that should be removed
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }

    /**
     * @return balls' list
     */
    @Override
    public List<Ball> getBallsList() {
        return this.ballList;
    }

    /**
     * @return paddle's rectangle
     */
    @Override
    public Rectangle getPaddleRectangle() {
        return null;
    }

    /**
     * @return paddle's color.
     */
    @Override
    public Color getPaddleColor() {
        return null;
    }

    /**
     * @return paddle's speed
     */
    @Override
    public int getPaddleSpeed() {
        return 0;
    }
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}
