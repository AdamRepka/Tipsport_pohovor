package application.controller.forrestObserverService;

import application.model.Direction;
import application.model.Forrest;
import application.model.Tree;

/**
 * Implementation on Forrest observer service interface
 *
 * @author Adam Repka
 */
public class ForrestObserverServiceImpl implements ForrestObserverServiceInt {

    private final Forrest forrest;

    public ForrestObserverServiceImpl(Forrest forrest) {
        this.forrest = forrest;
    }

    @Override
    public Tree moveTo(int x, int y, Direction direction) {
        return switch (direction) {
            case UP -> forrest.treeGrid().getTree(x, y - 1);
            case DOWN -> forrest.treeGrid().getTree(x, y + 1);
            case LEFT -> forrest.treeGrid().getTree(x - 1, y);
            case RIGHT -> forrest.treeGrid().getTree(x + 1, y);
        };
    }
}
