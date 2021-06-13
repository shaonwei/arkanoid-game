import animation.AnimationRunner;
import biuoop.GUI;
import game.GameFlow;

import interfaces.LevelInformation;
import levels.FirstLevel;
import levels.ForthLevel;
import levels.SecondLevel;
import levels.ThirdLevel;

import java.util.ArrayList;
import java.util.List;

import static common.Utils.FRAMES_PER_SECOND;
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
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s : args) {
            try {
                arr.add(Integer.valueOf(s));
            } catch (Exception e) {
            }
        }

        FirstLevel firstLevel = new FirstLevel();
        SecondLevel secondLevel = new SecondLevel();
        ThirdLevel thirdLevel = new ThirdLevel();
        ForthLevel forthLevel = new ForthLevel();
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        AnimationRunner animationRunner = new AnimationRunner(gui, FRAMES_PER_SECOND);
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
