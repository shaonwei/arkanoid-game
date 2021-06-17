package common;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon Weiss
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * constructor to SpriteCollection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * @param s Sprite
     *          add sprite to list
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * remove sprite from list.
     *
     * @param s Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }


    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> newSprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : newSprites) {
            sprite.timePassed();
        }

    }

    /**
     * @param d DrawSurface
     *          call drawOn(d) on all sprites.
     */
    public void drawAllOn(DrawSurface d) {
        try {
            for (Sprite sprite : this.sprites) {
                if (sprite != null) {
                    sprite.drawOn(d);
                } else {
                    this.sprites.size();
                }
            }
        } catch (Exception e) {
            this.sprites.size();
        }
    }

    /**
     * getter.
     *
     * @return sprites
     */
    public ArrayList<Sprite> getSprites() {
        return this.sprites;
    }

    /**
     * setter.
     *
     * @param arrayList List
     */
    public void setSprites(ArrayList<Sprite> arrayList) {
        this.sprites = this.sprites;
    }
}
