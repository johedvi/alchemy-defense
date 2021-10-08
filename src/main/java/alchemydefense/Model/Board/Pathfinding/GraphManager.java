package alchemydefense.Model.Board.Pathfinding;

import alchemydefense.Utility.Vector;

import java.util.HashMap;

// NEEDS DOCS, DONT COMMENT ON THIS IF YOU ARE REVIEWING :)))))
public class GraphManager {
    HashMap<Vector, PathNode> graph = new HashMap<>();

    public HashMap<Vector, PathNode> getGraph() {
        return graph;
    }

    public GraphManager(int width, int height){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Vector coordinates = new Vector(x,y);
                graph.put(coordinates, new PathNode(coordinates));
            }
        }
    }

    public void blockPathNode(Vector coordinates){
        if(graph.containsKey(coordinates)){
            graph.get(coordinates).setTraversable(false);
        }
    }

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
