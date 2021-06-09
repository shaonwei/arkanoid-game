package listeners;

import common.Counter;
import common.Utils;
import elements.Ball;
import elements.Block;
import game.Game;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class DuplicateBall implements HitListener {
    private Game game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game           game.Game
     * @param remainingBalls Counter
     */
    public DuplicateBall(Game game, Counter remainingBalls) {
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
        Ball newBall = hitter.duplicate();
        newBall.setVelocity(Utils.generateVelocity(newBall.getRadius()));
        newBall.addToGame(this.game);
        this.remainingBalls.increase(1);
        newBall.setGameEnvironment(this.game.getEnvironment());
    }
}
