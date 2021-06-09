package common;

/**
 * @author Sharon Weiss
 */
public class Counter {
    private int num;

    /**
     * constructor.
     *
     * @param num int
     */
    public Counter(int num) {
        this.num = num;
    }

    /**
     * add to score.
     *
     * @param number int
     */
    public void increase(int number) {
        this.num += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number int
     */

    public void decrease(int number) {
        this.num -= number;
    }

    /**
     * @return score
     */
    public int getValue() {
        return this.num;
    }
}
