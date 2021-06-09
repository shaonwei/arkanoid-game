package interfaces;

import common.Velocity;
import elements.Ball;
import elements.Block;
import geometric.Rectangle;

import java.awt.Color;
import java.util.List;

/**
 * @author Sharon Weiss
 */
public interface LevelInformation {
    /**
     * @return int- number of balls
     */
    int numberOfBalls();

    /**
     * @return list of velocities of balls
     * The initial velocity of each ball
     */
    // Note that initialBallVelocities().size() == numberOfBalls()
    List<Velocity> initialBallVelocities();

    /**
     * @return paddle speed
     */
    int paddleSpeed();

    /**
     * @return paddle width
     */
    int paddleWidth();

    /**
     * @return level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return list of blocks of the level
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    List<Block> blocks();

    /**
     * @return Number of blocks that should be removed
     */
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    int numberOfBlocksToRemove();

    /**
     * @return paddle's rectangle
     */
    Rectangle getPaddleRectangle();

    /**
     * @return paddle's color.
     */
    Color getPaddleColor();

    /**
     * @return paddle's speed
     */
    int getPaddleSpeed();

    /**
     * @return balls' list
     */
    List<Ball> getBallsList();
}
