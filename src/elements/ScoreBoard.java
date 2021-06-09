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
    private String levelName;

    /**
     * constructor.
     *
     * @param rectangle Rectangle
     * @param score     Counter
     * @param levelName String
     */
    public ScoreBoard(Rectangle rectangle, Counter score, String levelName) {
        super(rectangle);
        this.score = score;
        this.levelName = levelName;
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
        drawSurface.drawText(600, 25, this.levelName, 20);
    }
}
