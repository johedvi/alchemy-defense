package ModelTest;

import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;

import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author Willem Brahmstaedt
 * Created tests for DumbPathfinder
 *
 * Date: 2021-09-15
 */

public class DumbPathfinderTest {

    @Test
    public void testCalculatePath() {
        Vector2Int start = new Vector2Int(0,0);
        Vector2Int goal  = new Vector2Int(10,5);

        DumbPathfinder dumbPathfinder = new DumbPathfinder(goal);
        LinkedList<Vector2Int> list = dumbPathfinder.calculatePath(new LinkedList<Tower>(), start);

        Vector2Int previousPoint = new Vector2Int(start.x, start.y);
        for (Vector2Int p : list) {
            Assertions.assertTrue((Math.abs(p.x - previousPoint.x) == 1) ^ (Math.abs(p.y - previousPoint.y) == 1));
            previousPoint = new Vector2Int(p.x, p.y);
        }

        Assertions.assertEquals(list.get(list.size() - 1), goal);

        start = new Vector2Int(0,10);
        list = dumbPathfinder.calculatePath(new LinkedList<Tower>(), start);
        previousPoint = new Vector2Int(start.x, start.y);

        for (Vector2Int p : list) {
            Assertions.assertTrue((Math.abs(p.x - previousPoint.x) == 1) ^ (Math.abs(p.y - previousPoint.y) == 1));
            previousPoint = new Vector2Int(p.x, p.y);
        }

        Assertions.assertEquals(list.get(list.size() - 1), goal);
    }
}
