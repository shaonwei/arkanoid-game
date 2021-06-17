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

import static common.Utils.FRAMES_PER_SECOND;
import static common.Utils.HEIGHT;
import static common.Utils.WIDTH;

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

        int temp = 0;
        LevelsEnum levelsEnum;
        for (String s : args) {
            try {
                temp = Integer.parseInt(s) - 1;
                levelsEnum = LevelsEnum.values()[temp];
                switch (levelsEnum) {
                    case FIRST_LEVEL:
                        levels.add(new FirstLevel());
                        break;
                    case SECOND_LEVEL:
                        levels.add(new SecondLevel());
                        break;
                    case THIRD_LEVEL:
                        levels.add(new ThirdLevel());
                        break;
                    case FORTH_LEVEL:
                        levels.add(new ForthLevel());
                        break;
                    default:
                        break;
                }
            } catch (Exception ignored) {
            }
        }

        if (levels.size() == 0) {
            levels.add(new FirstLevel());
            levels.add(new SecondLevel());
            levels.add(new ThirdLevel());
            levels.add(new ForthLevel());
        }

        System.out.println(levels.toString());
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        AnimationRunner animationRunner = new AnimationRunner(gui, FRAMES_PER_SECOND);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui);
        gameFlow.runLevels(levels);
        gui.close();
    }
}
