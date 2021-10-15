package alchemydefense.Model.Board.Pathfinding;

import java.util.*;
import alchemydefense.Utility.Vector;

/**
 * Pathfinder class that can create paths when supplied a graph through a GraphManager to traverse. Uses breadth first search to search the graph
 * and returns the shortest list by keeping track of the nodes with a linked list.
 * @Author Felix Jönsson
 */
public class Pathfinder {
    Vector[] directions = {Vector.right(), Vector.down(), Vector.left(), Vector.up()};

    Vector start;
    Vector goal;

    Vector testStart;
    Vector testGoal;

    PathNode startNode;
    PathNode destinationNode;
    PathNode currentNode;

    HashMap<Vector, PathNode> explored = new HashMap<>();
    Queue<PathNode> nodeFront = new LinkedList<>();
    HashMap<Vector, PathNode> pathGraph;


    /**
     * Creates a new instance and assigns a GraphManager to it. Also sets up a start and goal
     * Vector for testing of possible path blocks.
     * @param graphManager the GraphManager assigned to this instance
     * @param testStart the start Vector used for testing possible path blocks.
     * @param testGoal the goal Vector used for testing possible path blocks.
     */
    public Pathfinder(GraphManager graphManager, Vector testStart, Vector testGoal){
        this.pathGraph = graphManager.getGraph();
        this.testStart = testStart;
        this.testGoal = testGoal;
    }

    /**
     * Creates and returns a new PathNode List using breadth first search. The breadth first search is set by default
     * to explore the neighbour to the right first in each node iteration.
     * @param start start position for the path to be generated
     * @param end end position for the path to be generated
     * @return list of PathNodes. Client can parse each PathNode coordinateVector to get a valid path to use.
     */
    public List<PathNode> generateNewPath(Vector start, Vector end) throws Exception {
        if(isValidVector(start) && isValidVector(end)){
            setup(start, end);
            breadthFirstSearch();
            return buildPath();
        }
        throw new Exception("Invalid path.");
    }

    private boolean isValidVector(Vector vector){
        return pathGraph.containsKey(vector);
    }

    /**
     * Sets the PathNode connected to the argument Vector temporarily to non-traversable. If this results in the path being
     * unable to find a valid path to the end destination the method will return false, else true.
     * @param coordinates coordinates of the PathNode to temporarily block
     * @return boolean representing whether blocking the PathNode results in blocking the path
     */
    public boolean blocksPath(Vector coordinates){
        if(pathGraph.containsKey(coordinates)){
            boolean previousNodeState = pathGraph.get(coordinates).isTraversable();
            pathGraph.get(coordinates).setTraversable(false);
            List<PathNode> path = null;
            try {
                path = generateNewPath(testStart, testGoal);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pathGraph.get(coordinates).setTraversable(previousNodeState);
            if(path.size() <= 1){
                return true;
            }
        }
        return false;
    }

    private void exploreAdjacentNodes(){
        List<PathNode> neighbors = new ArrayList<>();
        for (Vector direction : directions){
            Vector neighborCoordinate = currentNode.getCoordinateVector().add(direction);
            if(pathGraph.containsKey(neighborCoordinate)){
                neighbors.add(pathGraph.get(neighborCoordinate));
            }
        }

        for (PathNode neighbor : neighbors){
            if(!explored.containsKey(neighbor.getCoordinateVector()) && neighbor.isTraversable()){
                neighbor.setOriginNode(currentNode);
                explored.put(neighbor.getCoordinateVector(), neighbor);
                nodeFront.add(neighbor);
            }
        }
    }


    private void setup(Vector start, Vector end) {
        this.start = start;
        goal = end;
        startNode = new PathNode(this.start);
        destinationNode = new PathNode(goal);
        pathGraph.put(destinationNode.getCoordinateVector(), destinationNode);
        currentNode = startNode;
    }

    private void breadthFirstSearch(){
        nodeFront.clear();
        explored.clear();

        boolean isCalculatingPath = true;

        nodeFront.add(startNode);
        explored.put(startNode.getCoordinateVector(), startNode);

        while(!nodeFront.isEmpty() && isCalculatingPath){
            currentNode = nodeFront.remove();
            currentNode.setExplored(true);
            exploreAdjacentNodes();
            if(currentNode.getCoordinateVector() == goal){
                isCalculatingPath = false;
            }
        }
    }

    List<PathNode> buildPath(){
        List<PathNode> path = new ArrayList<>();
        PathNode currentNode = destinationNode;
        path.add(currentNode);
        currentNode.setCorrectPath(true);

        while(currentNode.getOriginNode() != null){
            currentNode = currentNode.getOriginNode();
            path.add(currentNode);
            currentNode.setCorrectPath(true);
        }
        Collections.reverse(path);

        return path;
    }
}
