package common;

import geometric.Point;
import interfaces.Collidable;

import java.util.ArrayList;

/**
 * @author Sharon Weiss
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable object;

    /**
     * @param collisionPoint Point
     * @param object         Collidable
     */
    public CollisionInfo(Point collisionPoint, Collidable object) {
        this.collisionPoint = collisionPoint;
        this.object = object;
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.object;
    }

    /**
     * @param start     Point
     * @param arrayList ArrayList<CollisionInfo>
     * @return closest point to start.
     */
    public static CollisionInfo closestCollision(Point start, ArrayList<CollisionInfo> arrayList) {

        if (arrayList.size() != 0) {

            CollisionInfo ret = arrayList.get(0);
            double minDistance = start.distance(ret.collisionPoint());
            for (int i = 1; i < arrayList.size(); i++) {
                double distance = start.distance(arrayList.get(i).collisionPoint());
                if (distance < minDistance) {
                    ret = arrayList.get(i);
                    minDistance = distance;
                }
            }
            return ret;
        }
        return null;
    }
}
