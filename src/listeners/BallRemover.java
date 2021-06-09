package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import game.Game;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class BallRemover implements HitListener {
    private Game game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game           game.Game
     * @param remainingBalls Counter
     */
    public BallRemover(Game game, Counter remainingBalls) {
        this.game = game;
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
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }

    /**
     * getter.
     *
     * @return game.Game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * setter.
     *
     * @param g game.Game
     */
    public void setGame(Game g) {
        this.game = g;
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
