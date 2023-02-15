package application.model;

/**
 * Record is used as overview entity to hold the grid of trees
 *
 * @param treeGrid - Grid of trees
 * @author Adam Repka
 */
public record Forrest(TreeGrid treeGrid) {

    /**
     * Checks if given coordinates are in current Forrest or not
     *
     * @param x - X coordinate
     * @param y - Y coordinate
     * @return True if coordinates are in the forrest, False if not
     */
    public boolean isInForrest(int x, int y) {
        return x > 0
                && x < treeGrid.getWidth() - 1
                && y > 0
                && y < treeGrid.getHeight() - 1;
    }
}
