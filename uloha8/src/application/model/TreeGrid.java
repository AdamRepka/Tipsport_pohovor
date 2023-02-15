package application.model;

import java.util.List;

/**
 * Record represents grid of trees in the forrest
 *
 * @param trees - 2D List of trees
 * @author Adam Repka
 */
public record TreeGrid(List<List<Tree>> trees) {

    /**
     * @return Width of the grid
     */
    public int getWidth() {
        return trees.size() == 0 ? 0 : trees().get(0).size();
    }

    /**
     * @return Height of the grid
     */
    public int getHeight() {
        return trees.size();
    }

    /**
     * Gets tree on given coordinates
     *
     * @param x int X coordinate
     * @param y int Y coordinate
     * @return Tree on given coordinates
     */
    public Tree getTree(int x, int y) {
        // Coordinates are out of grid
        if (x < 0
                || x >= getWidth()
                || y < 0
                || y >= getWidth())
            throw new IllegalArgumentException("Given coordinates are invalid! Current: x=" + x + " y=" + y +
                    "Limits: x=<0, " + (getWidth() - 1) + "> y=<0, " + (getHeight() - 1) + ">");
        return trees.get(y).get(x);
    }
}
