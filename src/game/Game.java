package game;

import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import common.Counter;
import common.SpriteCollection;
import common.Utils;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import elements.ScoreBoard;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.Sprite;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.DuplicateBall;
import listeners.ScoreTrackingListener;

import java.awt.Color;
import java.util.Random;

/**
 * @author Sharon Weiss
 */
public class Game implements Animation {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int BORDER_WIDTH = 20;
    public static final int BLOCK_WIDTH = 60;
    public static final int BLOCK_HEIGHT = 30;
    public static final int BALLS = 1;
    public static final int RADIUS = 10;
    private static final int framesPerSecond = 60;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Paddle paddle;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private DuplicateBall duplicateBall;
    private ScoreTrackingListener scoreTrackingListener;
    private AnimationRunner runner;
    private boolean running;

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.paddle = new Paddle(this.gui, this.gui.getKeyboardSensor());
        this.blockCounter = new Counter(0);
        this.ballCounter = new Counter(0);
        this.score = new Counter(0);
        this.blockRemover = new BlockRemover(this, this.blockCounter);
        this.ballRemover = new BallRemover(this, this.ballCounter);
        this.duplicateBall = new DuplicateBall(this, this.ballCounter);
        this.scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.paddle.addToGame(this);
        this.runner = new AnimationRunner(this.gui, framesPerSecond);
        generateBorder();
        generateBlocks();
        //generateBalls();
        generateScoreBoard();
    }

    /**
     * generate blocks.
     */
    private void generateBlocks() {
        int count = 0;
        Random random = new Random();
        int rand1 = random.nextInt(70);
        int rand2 = random.nextInt(70);
        for (int i = 0; i < 6; i++) {
            Color color = Utils.generateColor();
            for (int k = 1; k < 13 - i; k++) {
                Rectangle rectangle = new Rectangle(new Point(WIDTH - ((k) * BLOCK_WIDTH) - BORDER_WIDTH,
                        i * BLOCK_HEIGHT + 100), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle);
                if (count == rand1) {
                    //killing block
                    block.addHitListener(this.ballRemover);
                    block.addHitListener(this.blockRemover);
                    block.addHitListener(this.scoreTrackingListener);
                    block.setColor(Color.black);
                    rand1 = 300;
                } else if (count == rand2) {
                    //duplicate ball
                    block.addHitListener(this.duplicateBall);
                    block.addHitListener(this.blockRemover);
                    block.addHitListener(this.scoreTrackingListener);
                    block.setColor(Color.red);
                    rand2 = 300;
                } else {
                    block.addHitListener(this.blockRemover);
                    block.addHitListener(this.scoreTrackingListener);
                    block.setColor(color);

                }
                block.addToGame(this);
                this.blockCounter.increase(1);
                count++;
            }
        }
    }

    /**
     * generate border.
     */
    private void generateBorder() {
        Rectangle topR = new Rectangle(new Point(0, BLOCK_HEIGHT), WIDTH, BORDER_WIDTH);
        Rectangle rightR = new Rectangle(new Point(WIDTH - BORDER_WIDTH, BORDER_WIDTH), BORDER_WIDTH, HEIGHT);
        Rectangle leftR = new Rectangle(new Point(0, BORDER_WIDTH), BORDER_WIDTH, HEIGHT);
        Rectangle bottomR = new Rectangle(new Point(BORDER_WIDTH, HEIGHT),
                WIDTH - 2 * BORDER_WIDTH, BORDER_WIDTH);
        Block top = new Block(topR);
        Block right = new Block(rightR);
        Block left = new Block(leftR);
        Block bottom = new Block(bottomR);
        Color c = Utils.generateColor();
        top.setColor(c);
        right.setColor(c);
        left.setColor(c);
        bottom.setColor(c);
        top.addToGame(this);
        right.addToGame(this);
        left.addToGame(this);
        bottom.addToGame(this);
        bottom.addHitListener(this.ballRemover);
    }

    /**
     * generate balls.
     */
    private void generateBalls() {
        for (int i = 0; i < BALLS; i++) {
            Point p = Utils.generatePoint();
            Ball b = new Ball(p, RADIUS, Utils.generateColor());
            b.setVelocity(Utils.generateVelocity(b.getRadius()));
            b.addToGame(this);
            this.ballCounter.increase(1);
            b.setGameEnvironment(this.environment);
        }
    }

    /**
     * create score board.
     */
    private void generateScoreBoard() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), WIDTH, BLOCK_HEIGHT);
        ScoreBoard board = new ScoreBoard(rectangle, this.score);
        board.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        DrawSurface d = this.gui.getDrawSurface();
        this.generateBalls();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
        if (this.blockCounter.getValue() == 0) {
            this.score.increase(100);
        }
        this.gui.close();
        return;
    }

    /**
     * @param c Collidable.
     *          add to collidable list
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s Sprite
     *          add to sprite list
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * remove collidable from game.GameEnvironment collidables.
     *
     * @param c Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove sprite.
     *
     * @param s Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * @return SpriteCollection
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }

    /**
     * @param s set game SpriteCollection to sprites.
     */
    public void setSprites(SpriteCollection s) {
        this.sprites = s;
    }

    /**
     * @return game's game.GameEnvironment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * @param e game.GameEnvironment- set game's game.GameEnvironment
     */
    public void setEnvironment(GameEnvironment e) {
        this.environment = e;
    }

    /**
     * @return game's gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * @param g GUI- set game's gui
     */
    public void setGui(GUI g) {
        this.gui = g;
    }

    /**
     * @return game's paddle
     */
    public Paddle getPaddle() {
        return this.paddle;
    }

    /**
     * @param p Paddle- set game's paddle
     */
    public void setPaddle(Paddle p) {
        this.paddle = p;
    }

    /**
     * getter.
     *
     * @return listeners.BlockRemover
     */
    public BlockRemover getBlockRemover() {
        return this.blockRemover;
    }

    /**
     * getter.
     *
     * @return listeners.BallRemover
     */
    public BallRemover getBallRemover() {
        return this.ballRemover;
    }

    /**
     * @param d DrawSurface
     *          draws on frame on gui.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        //   this.gui.show(d);
        this.sprites.notifyAllTimePassed();
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new PauseScreen(this.gui.getKeyboardSensor()));
        }
    }

    /**
     * @return true if drawing should stop
     * else return false.
     */
    @Override
    public boolean shouldStop() {
        return !(this.blockCounter.getValue() > 0 && this.ballCounter.getValue() > 0);

//        return !this.running;
    }
}
