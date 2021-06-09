package elements;

import biuoop.DrawSurface;
import common.CollisionInfo;
import common.Velocity;
import game.GameLevel;
import game.GameEnvironment;
import geometric.Line;
import geometric.Point;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Ball object.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor to Point.
     *
     * @param center Point
     * @param r      int- radius
     * @param color  Color
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * constructor to Point.
     *
     * @param x     int - coordinates
     * @param y     int - coordinates
     * @param r     int- radius
     * @param color Color
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * change ball's center coordinates by velocity.
     */
    public void moveOneStep() {

        Point endPoint = this.velocity.applyToPoint(this.center);
        Line trajectory = new Line(this.center, endPoint);
        CollisionInfo collision = this.gameEnvironment.getClosestCollision(trajectory);
        /*while (checkForCollision() != null) {
            this.velocity = collision.collisionObject().hit(collision.collisionPoint(), this.velocity);
        }*/
        if (collision != null) {
            this.velocity = collision.collisionObject().hit(this, collision.collisionPoint(), this.velocity);
            endPoint = this.velocity.applyToPoint(this.center);
            trajectory = new Line(this.center, endPoint);
            collision = this.gameEnvironment.getClosestCollision(trajectory);
            if (collision != null) {
                this.velocity = collision.collisionObject().hit(this, collision.collisionPoint(), this.velocity);
            }
            return;
        }
        /*if (isInRect() != null) {
            this.setCenter(isInRect(), this.getY());
        }*/
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * @return Ball with same params
     */
    public Ball duplicate() {
        return new Ball(this.center, this.radius, this.color);
    }

    /**
     * @return CollisionInfo - if has collision
     */
    private CollisionInfo checkForCollision() {
        Point endPoint = this.velocity.applyToPoint(this.center);
        Line trajectory = new Line(this.center, endPoint);
        return this.gameEnvironment.getClosestCollision(trajectory);
    }

    /**
     * @param surface DrawSurface- paint the ball on surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    /**
     * execute move moveOneStep() after time passed.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * @param v set velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set velocity by delta.
     *
     * @param dx double- delta x
     * @param dy double- delta y
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return ball's velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * @return ball's game environment .
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * @param game set ball's game environment.
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * @return ball's radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param newRadius int- radius of ball
     */
    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    /**
     * @return ball's center x coordinate
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return ball's center y coordinate
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return ball's radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * @return ball's color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return coordinates of ball center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @param newCenter Point of newCenter of ball
     */
    public void setCenter(Point newCenter) {
        this.center = newCenter;
    }

    /**
     * @param x double - x coordinate of center of ball
     * @param y double - y coordinate of center of ball
     */
    public void setCenter(double x, double y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    /**
     * @param newColor Color- ball's color
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * @param gameLevel add
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * remove ball from game.
     *
     * @param gameLevel game.Game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}