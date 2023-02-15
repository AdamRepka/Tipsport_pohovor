package application.controller;

/**
 * Interface for forrest service
 *
 * @author Adam Repka
 */
public interface ForrestServiceInt {
    /**
     * @return int All visible trees of the forrest from outside
     */
    int getVisibleTrees();

    /**
     * @return int The highest scenic score of a single tree from whole forrest
     */
    int getHighestScenicScore();
}
