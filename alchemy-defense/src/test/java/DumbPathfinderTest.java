import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;

import alchemydefense.Model.Towers.Tower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
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
        Point start = new Point(0,0);
        Point goal  = new Point(10,5);

        DumbPathfinder dumbPathfinder = new DumbPathfinder(goal);
        LinkedList<Point> list = dumbPathfinder.calculatePath(new LinkedList<Tower>(), start);

        Point previousPoint = new Point(start.x, start.y);
        for (Point p : list) {
            Assertions.assertTrue((Math.abs(p.x - previousPoint.x) == 1) ^ (Math.abs(p.y - previousPoint.y) == 1));
            previousPoint = new Point(p.x, p.y);
        }

        Assertions.assertEquals(list.get(list.size() - 1), goal);
    }
}
