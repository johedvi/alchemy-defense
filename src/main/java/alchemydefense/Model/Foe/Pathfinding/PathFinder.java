package alchemydefense.Model.Foe.Pathfinding;


import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;

import java.util.LinkedList;
import java.util.List;


/**
 * Interface for pathfinding classes. Part of implementation of strategy pattern.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-15
 */
public interface PathFinder {
    LinkedList<Vector> calculatePath(List<Tower> towers, Vector currentPos);
}
