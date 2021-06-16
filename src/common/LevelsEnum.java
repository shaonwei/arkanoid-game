package common;

/**
 * @author Sharon Weiss
 */
public enum LevelsEnum {
    FIRST_LEVEL(1),
    SECOND_LEVEL(2),
    THIRD_LEVEL(3),
    FORTH_LEVEL(4);

    private int value;

    /**
     * constructor.
     *
     * @param value int
     */
    LevelsEnum(int value) {
        this.value = value;
    }
}
