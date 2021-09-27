package alchemydefense.Model.Foe.Pathfinding;


import alchemydefense.Model.Towers.Tower;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Willem Brahmstaedt
 * Pathfinder that returns a stupid path
 *
 * Date: 2021-09-15
 */

public class DumbPathfinder implements PathFinder {
    private final Point goal;

    public DumbPathfinder(Point goal) {
        this.goal = goal;
    }

    /**
     * Method that calculates a path without taking towers into account
     * @param towers List of towers on the board
     * @param startingPos Starting position
     * @return A list of points leading to the goal
     */
    @Override
    public LinkedList<Point> calculatePath(List<Tower> towers, Point startingPos) {
        LinkedList<Point> path = new LinkedList<>();
        Point currentPos = new Point(startingPos.x, startingPos.y);

        // Path in x direction
        for (int i = currentPos.x + 1; i < this.goal.x; i++) {
            currentPos.x = i;
            Point intPoint = new Point(i, currentPos.y);
            path.add(intPoint);
        }

        // Path in y direction
        for (int i = currentPos.y + 1; i <= this.goal.y; i++) {
            currentPos.y = i;
            Point intPoint = new Point(currentPos.x, i);
            path.add(intPoint);
        }

        // Path in negative y direction
        for (int i = currentPos.y - 1; i >= this.goal.y; i--) {
            currentPos.y = i;
            Point intPoint = new Point(currentPos.x, i);                    // xd
            path.add(intPoint);
        }



        // The very last step to the goal
        path.add(goal);

        return path;
    }
}
