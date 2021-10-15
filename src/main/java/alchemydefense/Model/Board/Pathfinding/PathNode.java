package alchemydefense.Model.Board.Pathfinding;

import alchemydefense.Utility.Vector;

import java.util.Objects;

/**
 * Data container class used for creating paths through the Pathfinder class.
 * @author Felix Jönsson
 */
public class PathNode {
    private Vector coordinateVector;
    private boolean isTraversable = true;
    private boolean isExplored;
    private boolean isCorrectPath;
    private PathNode originNode;

    public PathNode(Vector coordinateVector){
        this.setCoordinateVector(coordinateVector);
    }

    @Override
    public String toString(){
        return getCoordinateVector().toString();
    }

    public boolean isTraversable() {
        return isTraversable;
    }

    public void setTraversable(boolean traversable) {
        isTraversable = traversable;
    }

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public void setCorrectPath(boolean correctPath) {
        isCorrectPath = correctPath;
    }

    public PathNode getOriginNode() {
        return originNode;
    }

    public void setOriginNode(PathNode originNode) {
        this.originNode = originNode;
    }

    public Vector getCoordinateVector() {
        return coordinateVector;
    }

    public void setCoordinateVector(Vector coordinateVector) {
        this.coordinateVector = coordinateVector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathNode pathNode = (PathNode) o;
        return Objects.equals(coordinateVector, pathNode.coordinateVector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateVector, isTraversable, isExplored, isCorrectPath);
    }
}
