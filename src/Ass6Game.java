import common.Counter;
import game.GameLevel;
import levels.FirstLevel;
import levels.ForthLevel;
import levels.SecondLevel;
import levels.ThirdLevel;

/**
 * @author Sharon Weiss
 */
public class Ass6Game {

    /**
     * @param args String[]
     *             main function starts the game
     */
    public static void main(String[] args) {
        ForthLevel firstLevel = new ForthLevel();
        //ThirdLevel firstLevel = new ThirdLevel();
        //FirstLevel firstLevel = new FirstLevel();
        //SecondLevel firstLevel = new SecondLevel();

        Counter score = new Counter(0);
        GameLevel gameLevel = new GameLevel(firstLevel, score);
        gameLevel.run();
    }
}
