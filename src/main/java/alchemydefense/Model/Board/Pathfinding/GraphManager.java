package alchemydefense.Model.Board.Pathfinding;

import alchemydefense.Utility.Vector;

import java.util.HashMap;

/**
 * Sets up a graph of PathNodes connected to a specific Vector through a HasMap. Offers graph management
 * through various methods.
 * @author Felix Jönsson
 */
public class GraphManager {
    private HashMap<Vector, PathNode> graph = new HashMap<>();

    public HashMap<Vector, PathNode> getGraph() {
        return graph;
    }

    /**
     * Creates a new instance of a GraphManager and assigns the dimensions of the graph.
     * @param width width dimension
     * @param height height dimension
     */
    public GraphManager(int width, int height){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Vector coordinates = new Vector(x,y);
                graph.put(coordinates, new PathNode(coordinates));
            }
        }
    }

    /**
     * Blocks the PathNode connected to the argument Vector.
     * @param coordinates PathNode to block
     */
    public void blockPathNode(Vector coordinates){
        if(graph.containsKey(coordinates)){
            graph.get(coordinates).setTraversable(false);
        }
    }

    /**
     * Unblocks the PathNode connected to the argument Vector.
     * @param coordinates PathNode to unblock
     */
    public void unblockPathNode(Vector coordinates){
        if(graph.containsKey(coordinates)){
            graph.get(coordinates).setTraversable(true);
        }
    }

    /*
    public void resetPathNodes(){
        for (Map.Entry<Vector2Int, PathNode> entry : graph.entrySet()){
            entry.getValue().originNode = null;
            entry.getValue().isExplored = false;
            entry.getValue().isCorrectPath = false;
        }
    }

     */

}
