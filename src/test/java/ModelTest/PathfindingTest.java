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
        List<PathNode> pathNodes = pathfinder.generateNewPath(startPosition,endPosition);
        List<PathNode> targetPathNodes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Vector v = new Vector(i,2);
            targetPathNodes.add(new PathNode(v));
        }

        Assertions.assertTrue(pathNodes.containsAll(targetPathNodes));




    }

}
