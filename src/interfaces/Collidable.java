package interfaces;

import common.Velocity;
import elements.Ball;
import geometric.Point;
import geometric.Rectangle;

/**
 * @author Sharon Weiss
 */
public interface Collidable {
    /**
     * @return Return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  Point
     * @param currentVelocity Velocity
     * @param hitter          Ball
     * @return the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
