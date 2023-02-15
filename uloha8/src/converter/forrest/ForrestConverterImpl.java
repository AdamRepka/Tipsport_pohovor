package converter.forrest;

import application.model.Coordinates;
import application.model.Forrest;
import application.model.Tree;
import application.model.TreeGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Forrest converter interface
 * @author Adam Repka
 */
public class ForrestConverterImpl implements ForrestConverterInt {

    private final String input;

    public ForrestConverterImpl(String input) {
        this.input = input;
    }

    @Override
    public Forrest convert() {
        int x = 0, y = 0; // Coordinates of the tree
        List<String> trees = input.lines().toList(); // Lines of trees separated
        List<List<Tree>> grid = new ArrayList<>();
        for (String treeLine : trees) { // Line of trees
            List<Tree> line = new ArrayList<>();
            for (char tree : treeLine.toCharArray()) { // Each Tree is one char in String (one line in input)
                if (tree == '\n') break;
                line.add(new Tree(Integer.parseInt(String.valueOf(tree)), new Coordinates(x, y))); // Add Tree to line
                x++;
            }
            grid.add(line); // Add line to grid
            y++; // Move to the new row
            x = 0; // Move to the beginning of the row
        }
        return new Forrest(new TreeGrid(grid)); // Returns converted forrest created from grid
    }
}
