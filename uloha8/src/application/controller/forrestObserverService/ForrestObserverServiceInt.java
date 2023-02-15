package application.controller.forrestObserverService;

import application.model.Direction;
import application.model.Tree;

/**
 * Service interface for moving between trees in the forrest
 *
 * @author Adam Repka
 */
public interface ForrestObserverServiceInt {
    /**
     * Moves to new coordinates in given direction
     *
     * @param x         - Starting X coordinate
     * @param y         - Starting Y coordinate
     * @param direction - Direction where to go
     * @return Tree next to current tree
     */
    Tree moveTo(int x, int y, Direction direction);
}
