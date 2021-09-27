package alchemydefense.Model.Foe.Pathfinding;


import alchemydefense.Model.Towers.Tower;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Willem Brahmstaedt
 * Interface for pathfinding classes. Part of implementation of strategy pattern.
 *
 * Date: 2021-09-15
 */

public interface PathFinder {
    LinkedList<Point> calculatePath(List<Tower> towers, Point currentPos);
}
