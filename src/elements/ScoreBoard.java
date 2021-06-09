package elements;

import biuoop.DrawSurface;
import common.Counter;
import common.Utils;
import geometric.Rectangle;

import java.awt.Color;

/**
 * @author Sharon Weiss
 */
public class ScoreBoard extends Block {

    private Counter score;

    /**
     * constructor.
     *
     * @param rectangle Rectangle
     * @param score     Counter
     */
    public ScoreBoard(Rectangle rectangle, Counter score) {
        super(rectangle);
        this.score = score;
        this.setColor(Utils.generateColor());
    }

    /**
     * getter.
     *
     * @return score
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * setter.
     *
     * @param scoreC Counter
     */
    public void setScore(Counter scoreC) {
        this.score = scoreC;
    }

    /**
     * @param drawSurface DrawSurface- draw block
     */
    @Override
    public void drawOn(DrawSurface drawSurface) {
        super.drawOn(drawSurface);
        drawSurface.setColor(Color.black);
        drawSurface.drawText(350, 25, "Score: " + this.score.getValue(), 20);
    }
}
