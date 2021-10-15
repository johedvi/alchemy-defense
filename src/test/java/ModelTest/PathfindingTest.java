package ModelTest;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.Pathfinding.GraphManager;
import alchemydefense.Model.Board.Pathfinding.Pathfinder;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void test(){
        
    }

}
