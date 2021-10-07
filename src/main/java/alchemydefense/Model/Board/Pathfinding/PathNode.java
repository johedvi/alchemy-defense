package alchemydefense.Model.Board.Pathfinding;

import alchemydefense.Utility.Vector;

// NEEDS DOCS, DONT COMMENT ON THIS IF YOU ARE REVIEWING :)))))
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
}
