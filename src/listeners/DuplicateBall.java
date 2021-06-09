package listeners;

import common.Counter;
import common.Utils;
import elements.Ball;
import elements.Block;
import game.GameLevel;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class DuplicateBall implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel      game.Game
     * @param remainingBalls Counter
     */
    public DuplicateBall(GameLevel gameLevel, Counter remainingBalls) {
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
        Ball newBall = hitter.duplicate();
        newBall.setVelocity(Utils.generateVelocity());
        newBall.addToGame(this.gameLevel);
        this.remainingBalls.increase(1);
        newBall.setGameEnvironment(this.gameLevel.getEnvironment());
    }
}
