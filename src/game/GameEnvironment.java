package game;

import common.CollisionInfo;
import geometric.Line;
import interfaces.Collidable;

import java.util.ArrayList;

/**
 * @author Sharon Weiss
 */
public class GameEnvironment {
    private ArrayList<Collidable> arrayList;


    /**
     * game.GameEnvironment constructor.
     */
    public GameEnvironment() {
        this.arrayList = new ArrayList<>();
    }

    /**
     * @return collidable list
     */
    public ArrayList<Collidable> getArrayList() {
        return this.arrayList;
    }

    /**
     * @param c Collidable-add the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        this.arrayList.add(c);
    }

    /**
     * remove c from collidables.
     *
     * @param c Collidable
     */
    public void removeCollidable(Collidable c) {
        this.arrayList.remove(c);
    }

    /**
     * @param trajectory Line
     * @return Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */

    public CollisionInfo getClosestCollision(Line trajectory) {
        ArrayList<CollisionInfo> collisionInfos = new ArrayList<>();
        for (int i = 0; i < this.arrayList.size(); i++) {
            CollisionInfo c = new CollisionInfo((trajectory.closestIntersectionToStartOfLine(this.arrayList.get(i).
                    getCollisionRectangle())), this.arrayList.get(i));
            if (c.collisionPoint() != null) {
                collisionInfos.add(c);
            }
        }
        return CollisionInfo.closestCollision(trajectory.start(), collisionInfos);
    }
}
