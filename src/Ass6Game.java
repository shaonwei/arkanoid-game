import animation.AnimationRunner;
import biuoop.GUI;
import common.Counter;
import game.GameFlow;
import game.GameLevel;
import interfaces.LevelInformation;
import levels.FirstLevel;
import levels.ForthLevel;
import levels.SecondLevel;
import levels.ThirdLevel;

import java.util.ArrayList;
import java.util.List;

import static common.Utils.FRAMESPERSECOND;
import static game.GameLevel.HEIGHT;
import static game.GameLevel.WIDTH;

/**
 * @author Sharon Weiss
 */
public class Ass6Game {

    /**
     * @param args String[]
     *             main function starts the game
     */
    public static void main(String[] args) {
        FirstLevel firstLevel = new FirstLevel();
        SecondLevel secondLevel = new SecondLevel();
        ThirdLevel thirdLevel = new ThirdLevel();
        ForthLevel forthLevel = new ForthLevel();
/*
        GameLevel gameLevel = new GameLevel(firstLevel, score);
        gameLevel.run();*/
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);

        AnimationRunner animationRunner = new AnimationRunner(gui, FRAMESPERSECOND);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui);
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(firstLevel);
        levels.add(secondLevel);
        levels.add(thirdLevel);
        levels.add(forthLevel);
        gameFlow.runLevels(levels);
        gui.close();
    }
}
