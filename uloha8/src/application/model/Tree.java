package application.model;

/**
 * Record represents one tree in the forrest
 *
 * @param height      - int Height of the tree
 * @param coordinates - Coordinates of the tree in the forrest
 * @author Adam Repka
 */
public record Tree(int height, Coordinates coordinates) {
}
