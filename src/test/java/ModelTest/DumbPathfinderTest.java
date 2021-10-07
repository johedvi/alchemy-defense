package ModelTest;

import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;

import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;
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
        Vector start = new Vector(0,0);
        Vector goal  = new Vector(10,5);

        DumbPathfinder dumbPathfinder = new DumbPathfinder(goal);
        LinkedList<Vector> list = dumbPathfinder.calculatePath(new LinkedList<Tower>(), start);

        Vector previousPoint = new Vector(start.x, start.y);
        for (Vector p : list) {
            Assertions.assertTrue((Math.abs(p.x - previousPoint.x) == 1) ^ (Math.abs(p.y - previousPoint.y) == 1));
            previousPoint = new Vector(p.x, p.y);
        }

        Assertions.assertEquals(list.get(list.size() - 1), goal);

        start = new Vector(0,10);
        list = dumbPathfinder.calculatePath(new LinkedList<Tower>(), start);
        previousPoint = new Vector(start.x, start.y);

        for (Vector p : list) {
            Assertions.assertTrue((Math.abs(p.x - previousPoint.x) == 1) ^ (Math.abs(p.y - previousPoint.y) == 1));
            previousPoint = new Vector(p.x, p.y);
        }

        Assertions.assertEquals(list.get(list.size() - 1), goal);
    }
}
