package elements;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import common.Utils;
import common.Velocity;
import game.Game;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Collidable;
import interfaces.Sprite;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private biuoop.GUI gui;
    private Rectangle rectangle;
    private Color color;
    private double[] regions;

    /**
     * @param gui      GUI
     * @param keyboard KeyboardSensor
     *                 Paddle constructor
     */
    public Paddle(biuoop.GUI gui, KeyboardSensor keyboard) {
        this.gui = gui;
        this.keyboard = keyboard;
        this.rectangle = new Rectangle(new Point(Utils.START_POINT, 560), 90, 20);
        this.color = Utils.generateColor();
        this.regions = new double[6];
        setRegions();
    }

    /**
     * set 5 regions of paddle.
     */
    private void setRegions() {
        int part = this.rectangle.getWidth() / 5;
        for (int i = 0; i < this.regions.length; i++) {
            this.regions[i] = this.rectangle.getUpperLeft().getX() + i * part;
        }
    }

    /**
     * @return paddle's color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @param c Color- set paddle's color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * move paddle to left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() > 0) {
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() - 5,
                    this.rectangle.getUpperLeft().getY()));
            setRegions();
        }
    }

    /**
     * move paddle to right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() < Game.WIDTH) {
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() + 5,
                    this.rectangle.getUpperLeft().getY()));
            setRegions();
        }
    }

    /**
     * call moveLeft() or moveRight() if keys were pressed.
     */
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * @param d DrawSurface- draw paddle
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * @param g game.Game
     *          Add this paddle to the game.
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * @return paddles rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param collisionPoint  Point
     * @param currentVelocity Velocity
     * @return velocity after hit
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) <= Utils.EPSILON
                || Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                <= Utils.EPSILON) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        if (Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) <= Utils.EPSILON) {
            newVelocity = changeVelocity(collisionPoint, currentVelocity);

        }
        return newVelocity;
    }

    /**
     * @param collisionPoint  Point
     * @param currentVelocity Velocity
     * @return new velocity according to the region ball hit.
     */
    private Velocity changeVelocity(Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        int part = 0;
        for (int i = 1; i < this.regions.length; i++) {
            if (this.regions[i - 1] < collisionPoint.getX() && collisionPoint.getX() < this.regions[i]) {
                part = i;
            }
        }

        switch (part) {
            case 1:
                newVelocity = Velocity.fromAngleAndSpeed(-60, currentVelocity.getSpeedFromVelocity());
                break;
            case 2:
                newVelocity = Velocity.fromAngleAndSpeed(-30, currentVelocity.getSpeedFromVelocity());
                break;
            case 3:
                newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
                break;
            case 4:
                newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeedFromVelocity());
                break;
            case 5:
                newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeedFromVelocity());
                break;
            default:
                newVelocity = Velocity.fromAngleAndSpeed(0, currentVelocity.getSpeedFromVelocity());
        }
        return newVelocity;
    }
}
