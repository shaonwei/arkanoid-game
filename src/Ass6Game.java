import animation.AnimationRunner;
import biuoop.GUI;
import common.LevelsEnum;
import game.GameFlow;

import interfaces.LevelInformation;
import levels.FirstLevel;
import levels.ForthLevel;
import levels.SecondLevel;
import levels.ThirdLevel;

import java.util.ArrayList;
import java.util.List;

import static common.LevelsEnum.FIRST_LEVEL;
import static common.LevelsEnum.FORTH_LEVEL;
import static common.LevelsEnum.SECOND_LEVEL;
import static common.LevelsEnum.THIRD_LEVEL;
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
        List<LevelInformation> levels = new ArrayList<>();
        FirstLevel firstLevel = new FirstLevel();
        SecondLevel secondLevel = new SecondLevel();
        ThirdLevel thirdLevel = new ThirdLevel();
        ForthLevel forthLevel = new ForthLevel();
        int temp = 0;
        LevelsEnum levelsEnum = LevelsEnum.values()[temp];
        for (String s : args) {
            try {
                temp = Integer.valueOf(s) - 1;
                levelsEnum = LevelsEnum.values()[temp];
                switch (levelsEnum) {
                    case FIRST_LEVEL:
                        levels.add(firstLevel);
                        break;
                    case SECOND_LEVEL:
                        levels.add(secondLevel);
                        break;
                    case THIRD_LEVEL:
                        levels.add(thirdLevel);
                        break;
                    case FORTH_LEVEL:
                        levels.add(forthLevel);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
            }


        }
        if (levels.size() == 0) {
            levels.add(firstLevel);
            levels.add(secondLevel);
            levels.add(thirdLevel);
            levels.add(forthLevel);
        }
        System.out.println(levels.toString());
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        AnimationRunner animationRunner = new AnimationRunner(gui, FRAMES_PER_SECOND);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui);
        levels.add(firstLevel);
        levels.add(secondLevel);
        levels.add(thirdLevel);
        levels.add(forthLevel);
        gameFlow.runLevels(levels);
        gui.close();
    }

    private void fillList() {

    }
}
