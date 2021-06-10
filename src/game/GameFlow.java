package game;

import animation.AnimationRunner;
import animation.EndScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import common.Counter;
import interfaces.LevelInformation;

import java.util.List;

/**
 * @author Sharon Weiss
 */
public class GameFlow {
    private GUI gui;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * constructor.
     *
     * @param ar  AnimationRunner
     * @param ks  KeyboardSensor
     * @param gui GUI
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.score = new Counter(0);
    }

    /**
     * run game.
     *
     * @param levels List
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean isWin = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui, this.score);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.getBallCounter().getValue() == 0) {
                isWin = false;
                break;
            }
        }
        this.animationRunner.run(new EndScreen(this.keyboardSensor, isWin, this.score.getValue()));
        return;
    }
}
