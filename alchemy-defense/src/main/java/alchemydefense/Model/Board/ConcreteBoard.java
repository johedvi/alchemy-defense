package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Player.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConcreteBoard implements Board {

    private final DumbPathfinder pathfinder = new DumbPathfinder(new Point(10, 10));

    private final HashMap<ConcreteFoe, LinkedList<Point>> paths = new HashMap<>();

    PositionalGrid positionalGrid;
    final int width = 10;
    final int height = 5;

    public ConcreteBoard(){
        positionalGrid = new PositionalGrid(width, height);
    }

    public BoardObject getBoardObject(Point point){
        return positionalGrid.get(point);
    }

    @Override
    public void placeBoardObject(BoardObject boardObject, Point worldPosition) {
        positionalGrid.add(boardObject, worldPosition);
    }

    public void removeBoardObject(Point point){
        positionalGrid.remove(point);
    }

    public void calculatePath(ConcreteFoe foe) {
        //LinkedList<Point> path = pathfinder.calculatePath(null, positionalGrid.getPos(foe));
        //paths.put(foe, path;
    }

    public void moveFoes(List<ConcreteFoe> foes) {
        for(ConcreteFoe foe : foes) {
            if(paths.get(foe).size() == 1) {
                paths.remove(foe);
                //Remove foe from list of active foes.
                Player.getPlayer().decreaseOneHp();
            }
        }
    }
}
