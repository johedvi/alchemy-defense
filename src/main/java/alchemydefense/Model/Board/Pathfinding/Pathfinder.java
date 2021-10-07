package alchemydefense.Model.Board.Pathfinding;

import java.util.*;

// NEEDS DOCS, DONT COMMENT ON THIS IF YOU ARE REVIEWING :)))))
public class Pathfinder {
    Vector[] directions = {Vector.right(), Vector.down(), Vector.left(), Vector.up()};

    Vector start;
    Vector goal;

    PathNode startNode;
    PathNode destinationNode;
    PathNode currentNode;

    HashMap<Vector, PathNode> explored = new HashMap<>();
    Queue<PathNode> nodeFront = new LinkedList<>();
    HashMap<Vector, PathNode> pathGraph;

    public Pathfinder(GraphManager graphManager){
        pathGraph = graphManager.getGraph();
    }

    public List<PathNode> generateNewPath(Vector start, Vector end){
        this.start = start;
        goal = end;
        startNode = new PathNode(this.start);
        destinationNode = new PathNode(goal);
        pathGraph.put(destinationNode.getCoordinateVector(), destinationNode);
        currentNode = startNode;
        breadthFirstSearch();
        return buildPath();
    }

    public void exploreAdjacentNodes(){
        List<PathNode> neighbors = new ArrayList<>();
        for (Vector direction : directions){
            Vector neighborCoords = currentNode.getCoordinateVector().add(direction);
            if(pathGraph.containsKey(neighborCoords)){
                neighbors.add(pathGraph.get(neighborCoords));
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

    public void breadthFirstSearch(){
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

    public boolean blocksPath(Vector coordinates){
        if(pathGraph.containsKey(coordinates)){
            boolean previousNodeState = pathGraph.get(coordinates).isTraversable();
            pathGraph.get(coordinates).setTraversable(false);
            List<PathNode> path = generateNewPath(new Vector(0,2), new Vector(11,2));
            pathGraph.get(coordinates).setTraversable(previousNodeState);
            System.out.println("Blocking path: " + path.toString());
            if(path.size() <= 1){
                return true;
            }
        }
        return false;
    }
}
