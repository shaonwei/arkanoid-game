package elements;

import biuoop.DrawSurface;
import common.Velocity;
import game.GameLevel;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon Weiss
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * @param rectangle set block shape to rectangle
     */
    public Block(Rectangle rectangle) {
        this.shape = rectangle;
        this.hitListeners = new ArrayList<>();
        this.color = Color.white;
    }

    /**
     * @return block rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * @param collisionPoint  Point
     * @param currentVelocity Velocity
     * @return velocity after hit
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (collisionPoint.getX() == this.shape.getUpperLeft().getX()
                || collisionPoint.getX() == this.shape.getUpperLeft().getX() + this.shape.getWidth()) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        if (collisionPoint.getY() == this.shape.getUpperLeft().getY()
                || collisionPoint.getY() == this.shape.getUpperLeft().getY() + this.shape.getHeight()) {
            newVelocity.setDy(-currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * @param s set block's shape
     */
    public void setShape(Rectangle s) {
        this.shape = s;
    }

    /**
     * getter.
     *
     * @return Rectangle
     */
    public Rectangle getShape() {
        return this.shape;
    }

    /**
     * @return get block's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param c set block's color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * @param drawSurface DrawSurface- draw block
     */
    @Override
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.lightGray);
        drawSurface.drawRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                this.shape.getWidth(), this.shape.getHeight());
        drawSurface.setColor(this.getColor());
        drawSurface.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                this.shape.getWidth(), this.shape.getHeight());

    }

    /**
     * nothing.
     */
    @Override
    public void timePassed() {

    }

    /**
     * @param gameLevel add block to game
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * remove block from game.
     *
     * @param gameLevel game.Game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
        removeHitListener(gameLevel.getBlockRemover());
    }

    /**
     * @param hl Add hl as a listener to hit events.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * @param hl Remove hl from the list of listeners to hit events.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * called whenever a hit() occurs.
     * notify all of the registered HitListener objects by calling their hitEvent method.
     *
     * @param hitter Ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
