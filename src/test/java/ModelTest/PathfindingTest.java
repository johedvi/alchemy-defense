package ModelTest;

import alchemydefense.Model.Board.Pathfinding.GraphManager;
import alchemydefense.Model.Board.Pathfinding.PathNode;
import alchemydefense.Model.Board.Pathfinding.Pathfinder;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PathfindingTest {
    Pathfinder pathfinder;
    GraphManager graphManager;
    Vector startPosition, endPosition;

    @BeforeEach
    public void setup(){
        startPosition = new Vector(0,2);
        endPosition = new Vector(11,2);
        graphManager =  new GraphManager(12,5);
        pathfinder = new Pathfinder(graphManager, startPosition, endPosition);
    }

    @Test
    public void testGeneratePath(){
        List<PathNode> pathNodes = null;
        try {
            pathNodes = pathfinder.generateNewPath(startPosition,endPosition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<PathNode> targetPathNodes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Vector v = new Vector(i,2);
            targetPathNodes.add(new PathNode(v));
        }
        Assertions.assertTrue(pathNodes.containsAll(targetPathNodes));
    }

    @Test
    public void testPositionsOutOfBounds(){
        List<PathNode> pathNodes;
        String actualMsg = "";
        String expectedMsg = "Invalid path.";
        try {
            pathNodes = pathfinder.generateNewPath(new Vector(0,6),endPosition);
        } catch (Exception e) {
            actualMsg = e.getMessage();
        }

        Assertions.assertTrue(expectedMsg.equals(actualMsg));

        try {
            pathNodes = pathfinder.generateNewPath(startPosition, new Vector(12,2));
        } catch (Exception e) {
            actualMsg = e.getMessage();
        }

        Assertions.assertTrue(expectedMsg.equals(actualMsg));
    }
}
