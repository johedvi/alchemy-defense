package alchemydefense.Model.Foe.Pathfinding;

import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;

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
    private final Vector2Int goal;

    public DumbPathfinder(Vector2Int goal) {
        this.goal = goal;
    }

    /**
     * Method that calculates a path without taking towers into account
     * @param towers List of towers on the board
     * @param startingPos Starting position
     * @return A list of points leading to the goal
     */
    @Override
    public LinkedList<Vector2Int> calculatePath(List<Tower> towers, Vector2Int startingPos) {
        LinkedList<Vector2Int> path = new LinkedList<>();
        Vector2Int currentPos = new Vector2Int(startingPos.getX(), startingPos.getY());

        // Path in x direction
        for (int i = currentPos.getX() + 1; i < this.goal.getX(); i++) {
            currentPos.setX(i);
            Vector2Int intPoint = new Vector2Int(i, currentPos.getY());
            path.add(intPoint);
        }

        // Path in y direction
        for (int i = currentPos.getY() + 1; i <= this.goal.getY(); i++) {
            currentPos.setY(i);
            Vector2Int intPoint = new Vector2Int(currentPos.getX(), i);
            path.add(intPoint);
        }

        // Path in negative y direction
        for (int i = currentPos.getY() - 1; i >= this.goal.getY(); i--) {
            currentPos.setY(i);
            Vector2Int intPoint = new Vector2Int(currentPos.getX(), i);
            path.add(intPoint);
        }
        // The very last step to the goal
        path.add(goal);

        return path;
    }
}
