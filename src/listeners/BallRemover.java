package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import game.GameLevel;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel           game.Game
     * @param remainingBalls Counter
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit Block
     * @param hitter   Ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        System.out.println("hit- ball remover"+hitter.toString());
        this.remainingBalls.decrease(1);
    }

    /**
     * getter.
     *
     * @return game.Game
     */
    public GameLevel getGame() {
        return this.gameLevel;
    }

    /**
     * setter.
     *
     * @param g game.Game
     */
    public void setGame(GameLevel g) {
        this.gameLevel = g;
    }

    /**
     * getter.
     *
     * @return Counter
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * setter.
     *
     * @param counter Counter
     */
    public void setRemainingBalls(Counter counter) {
        this.remainingBalls = counter;
    }

}
