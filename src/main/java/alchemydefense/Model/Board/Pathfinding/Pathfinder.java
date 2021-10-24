package alchemydefense.Model.Board.Pathfinding;

import alchemydefense.Utility.Vector;

import java.util.List;

public interface Pathfinder {

    List<PathNode> generateNewPath(Vector start, Vector end) throws Exception;

    boolean blocksPath(Vector coordinates);
}
