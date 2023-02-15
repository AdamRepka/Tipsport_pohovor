package application.controller.visionservice;

import application.controller.forrestObserverService.ForrestObserverServiceImpl;
import application.model.Coordinates;
import application.model.Direction;
import application.model.Forrest;
import application.model.Tree;

/**
 * Implementation of Vision interface
 *
 * @author Adam Repka
 */
public class VisionServiceImpl implements VisionServiceInt {

    private final Forrest forrest;
    private final ForrestObserverServiceImpl forrestObserverService;

    public VisionServiceImpl(Forrest forrest) {
        this.forrest = forrest;
        forrestObserverService = new ForrestObserverServiceImpl(forrest);
    }

    @Override
    public int getVisibleTrees() {
        return forrest.treeGrid().trees().stream().map(treeLine ->
                treeLine.stream().filter(this::isVisible).toList().size()
        ).mapToInt(Integer::intValue).sum();
    }

    /**
     * Checks if given tree is visible from outside or not
     *
     * @param tree - Tree to be checked
     * @return True if the tree is visible, False if not
     */
    private boolean isVisible(Tree tree) {
        Coordinates coordinates = tree.coordinates();
        // The tree is on the edge of the forrest - Instantly false
        if (coordinates.x() == 0
                || coordinates.x() == forrest.treeGrid().getWidth() - 1
                || coordinates.y() == 0
                || coordinates.y() == forrest.treeGrid().getHeight() - 1) return true;
        // Check all directions
        return isVisibleInDirection(tree, Direction.UP)
                || isVisibleInDirection(tree, Direction.DOWN)
                || isVisibleInDirection(tree, Direction.LEFT)
                || isVisibleInDirection(tree, Direction.RIGHT);
    }

    /**
     * Checks if given tree is visible in given Direction
     *
     * @param tree      - Tree to be checked
     * @param direction - Direction to be looked at
     * @return True if the tree is visible, False if not
     */
    private boolean isVisibleInDirection(Tree tree, Direction direction) {
        int height = tree.height(); // Get actual tree height
        Tree tmpTree = tree;
        while (forrest.isInForrest(tmpTree.coordinates().x(), tmpTree.coordinates().y())) {
            // Move to next tree in given direction
            tmpTree = forrestObserverService.moveTo(tmpTree.coordinates().x(), tmpTree.coordinates().y(), direction);
            // There is a tree higher than or same as starting tree -> Tree is invisible
            if (tmpTree.height() >= height) return false;
        }
        // No tree is higher than starting tree in this direction -> Tree is visible
        return true;
    }
}
