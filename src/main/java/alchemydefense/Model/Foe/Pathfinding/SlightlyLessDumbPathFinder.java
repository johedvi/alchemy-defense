package alchemydefense.Model.Foe.Pathfinding;

import alchemydefense.Model.Board.Grid.PositionalCell;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class SlightlyLessDumbPathFinder {

    private final Point goal;

    public SlightlyLessDumbPathFinder(Point goal) {
        this.goal = goal;
    }

    public LinkedList<Point> calculatePath(ArrayList<PositionalCell> cellsWithTowers, Point startingPos) {
        LinkedList<Point> path = new LinkedList<>();
        Point currentPos = new Point(startingPos.x, startingPos.y);
        ArrayList<Point> pointsWithTowers = new ArrayList<>();

        ArrayList<Point> visitedPoints = new ArrayList<>();

        //Gets coordinates from each cell occupied by a tower
        for(PositionalCell cell : cellsWithTowers) {
            pointsWithTowers.add(cell.getCellCoordinate());
        }

        while(!isGoalReached(currentPos)) {

            if(canGoTo(visitedPoints, pointsWithTowers, new Point(currentPos.x+1, currentPos.y)))
                currentPos.x++;

            else if(currentPos.y <= goal.y) {

                if(canGoTo(visitedPoints, pointsWithTowers, new Point(currentPos.x, currentPos.y+1)))
                    currentPos.y++;

                else if(canGoTo(visitedPoints, pointsWithTowers, new Point(currentPos.x, currentPos.y-1)))
                    currentPos.y--;
            }
            else {
                if(canGoTo(visitedPoints, pointsWithTowers, new Point(currentPos.x, currentPos.y-1)))
                    currentPos.y--;

                else if(canGoTo(visitedPoints, pointsWithTowers, new Point(currentPos.x, currentPos.y+1)))
                    currentPos.y++;

            }
            Point intPoint = new Point(currentPos.x, currentPos.y);
            path.add(intPoint);

            visitedPoints.add(intPoint);

            //currentPos = goal;
            System.out.println("currentPos x: " + currentPos.x);
            System.out.println("currentPos y: " + currentPos.y);
        }

        // The very last step to the goal
        //path.add(goal);

        return path;
    }

    private boolean canGoTo(ArrayList<Point> visited, ArrayList<Point> pointsWithTowers, Point targetPoint) {
        return isFreePosition(pointsWithTowers, targetPoint) && inRange(targetPoint) && !hasVisited(visited, targetPoint);
    }

    private boolean isFreePosition(ArrayList<Point> pointsWithTowers, Point testPoint) {
        for(Point tower : pointsWithTowers) {
            if(tower.x == testPoint.x && tower.y == testPoint.y)
                return false;
        }
        return true;
    }

    private boolean isGoalReached(Point currentPos) { return (currentPos.x == goal.x) && (currentPos.y == goal.y); }

    private boolean inRange(Point testPoint) {
        return (testPoint.x <= goal.x) && (testPoint.y >= 0) && (testPoint.y < 5);
    }

    private boolean hasVisited(ArrayList<Point> visitedPoints, Point testPoint) {
        for(Point visited : visitedPoints) {
            if(visited.x == testPoint.x && visited.y == testPoint.y)
                return true;
        }
        return false;
    }
}
