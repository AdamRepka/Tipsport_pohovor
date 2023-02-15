package application.controller.scenicscoreservice;

import application.controller.forrestObserverService.ForrestObserverServiceImpl;
import application.model.Direction;
import application.model.Forrest;
import application.model.Tree;

/**
 * Implementation of the Scenic service interface
 *
 * @author Adam Repka
 */
public class ScenicServiceImpl implements ScenicServiceInt {

    private final Forrest forrest;
    private final ForrestObserverServiceImpl forrestObserverService;

    public ScenicServiceImpl(Forrest forrest) {
        this.forrest = forrest;
        forrestObserverService = new ForrestObserverServiceImpl(forrest);
    }

    @Override
    public int getHighestScenicScore() {
        return forrest.treeGrid().trees().stream()
                .mapToInt(treeLine -> treeLine.stream()
                        .mapToInt(this::getScenicScore)
                        .max().orElseThrow())
                .max()
                .orElseThrow();
    }

    /**
     * Gets scenic score of given tree
     *
     * @param tree - Tree to be scored
     * @return int Scenic score of give tree
     */
    private int getScenicScore(Tree tree) {
        return getDistance(tree, Direction.UP)
                * getDistance(tree, Direction.DOWN)
                * getDistance(tree, Direction.LEFT)
                * getDistance(tree, Direction.RIGHT);
    }

    /**
     * Gets distance of vision from given tree to given direction
     *
     * @param tree      - Starting tree
     * @param direction - Direction where to look
     * @return int Number of trees visible from starting tree
     */
    private int getDistance(Tree tree, Direction direction) {
        int height = tree.height(), distance = 0; // Get actual height and set distance to 0
        Tree tmpTree = tree;
        while (forrest.isInForrest(tmpTree.coordinates().x(), tmpTree.coordinates().y())) {
            distance++; // For each tree traveled increase distance by one
            tmpTree = forrestObserverService.moveTo(tmpTree.coordinates().x(), tmpTree.coordinates().y(), direction);
            // There is tree blocking the view
            if (tmpTree.height() >= height) break;
        }
        // Maximal view distance in given direction
        return distance;
    }
}
