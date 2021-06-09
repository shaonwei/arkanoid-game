package elements;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import common.Utils;
import common.Velocity;
import game.GameLevel;
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
    private int speed;

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
        this.speed = 5;
    }

    /**
     * @param rect  Rect- set paddle's rectangle
     * @param c     Color- set paddle's color
     * @param speed Color- set paddle's speed
     */
    public Paddle(Rectangle rect, Color c, int speed) {
        this.rectangle = rect;
        this.color = c;
        this.regions = new double[6];
        setRegions();
        this.speed = speed;
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
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() - this.speed,
                    this.rectangle.getUpperLeft().getY()));
            setRegions();
        }
    }

    /**
     * move paddle to right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() < GameLevel.WIDTH) {
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() + this.speed,
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
    public void addToGame(GameLevel g) {
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

    /**
     * getter.
     *
     * @return rectangle of paddle
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * @param rectangle Rectangle- setter
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * getter.
     *
     * @return int- paddle's speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * setter.
     *
     * @param speed int
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * getter.
     *
     * @return KeyboardSensor
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    /**
     * setter.
     *
     * @param keyboard KeyboardSensor
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * getter.
     *
     * @return gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * setter.
     *
     * @param gui GUI
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }

}
