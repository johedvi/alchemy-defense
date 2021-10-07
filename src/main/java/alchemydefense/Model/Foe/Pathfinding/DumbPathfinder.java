package alchemydefense.Model.Foe.Pathfinding;

import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;

import java.util.LinkedList;
import java.util.List;

/**
 * Pathfinder that returns a stupid path
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-15
 */
public class DumbPathfinder implements PathFinder {
    private final Vector goal;

    public DumbPathfinder(Vector goal) {
        this.goal = goal;
    }

    /**
     * Method that calculates a path without taking towers into account
     * @param towers List of towers on the board
     * @param startingPos Starting position
     * @return A list of points leading to the goal
     */
    @Override
    public LinkedList<Vector> calculatePath(List<Tower> towers, Vector startingPos) {
        LinkedList<Vector> path = new LinkedList<>();
        Vector currentPos = new Vector(startingPos.x, startingPos.y);

        // Path in x direction
        for (int i = currentPos.x + 1; i < this.goal.x; i++) {
            currentPos.x = i;
            Vector intPoint = new Vector(i, currentPos.y);
            path.add(intPoint);
        }

        // Path in y direction
        for (int i = currentPos.y + 1; i <= this.goal.y; i++) {
            currentPos.y = i;
            Vector intPoint = new Vector(currentPos.x, i);
            path.add(intPoint);
        }

        // Path in negative y direction
        for (int i = currentPos.y - 1; i >= this.goal.y; i--) {
            currentPos.y = i;
            Vector intPoint = new Vector(currentPos.x, i);
            path.add(intPoint);
        }
        // The very last step to the goal
        path.add(goal);

        return path;
    }
}
