package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import game.GameLevel;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel          game.Game
     * @param removedBlocks Counter
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
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
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
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
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * setter.
     *
     * @param counter Counter
     */
    public void setRemainingBlocks(Counter counter) {
        this.remainingBlocks = counter;
    }
}
