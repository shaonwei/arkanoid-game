package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import game.Game;
import interfaces.HitListener;

/**
 * @author Sharon Weiss
 */
public class BlockRemover implements HitListener {
    private Game game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          game.Game
     * @param removedBlocks Counter
     */
    public BlockRemover(Game game, Counter removedBlocks) {
        this.game = game;
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
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
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
