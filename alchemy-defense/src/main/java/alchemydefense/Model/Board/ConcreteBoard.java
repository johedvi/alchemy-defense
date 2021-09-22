package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConcreteBoard implements Board {

    private final DumbPathfinder pathfinder = new DumbPathfinder(new Point(10, 10));

    private final HashMap<ConcreteFoe, LinkedList<Point>> paths = new HashMap<>();

    private final static Player player = Player.getPlayer();

    PositionalGrid positionalGrid;
    public final int width = 10;
    public final int height = 5;


    public ConcreteBoard(){
        positionalGrid = new PositionalGrid(width, height);
    }

    public BoardObject getBoardObject(Point point){
        return positionalGrid.getBoardObject(point);
    }

    public PositionalCell getCell(Point point){
        return positionalGrid.getCell(point);
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
        //paths.put(foe, path);
    }

    /**
     * Updates position and status of each foe.
     * @param foes is the list of current active foes.
     * @return updated list where foes that reached the end are removed.
     */
    public List<ConcreteFoe> updateFoes(List<ConcreteFoe> foes) {

        List<ConcreteFoe> activeFoes = new ArrayList<>(foes);
        for(ConcreteFoe foe : foes) {
            moveFoe(foe);
            if(foeReachedEnd(foe)) {
                paths.remove(foe);
                player.decreaseOneHp();
                activeFoes.remove(foe);
            }

            //damageControl(foe);
            if(!foe.isAlive())
                activeFoes.remove(foe);
        }
        return activeFoes;
    }

    private void moveFoe(ConcreteFoe foe) { paths.get(foe).removeFirst(); }

    //TODO get position of foe as argument to grid
    /*private void damageControl(ConcreteFoe foe) {
        int damage = potentialTowerDamage(positionalGrid.getPos(foe));
        if(damage > 0)
            foe.takeDamage(damage);

    }*/

    //TODO get access to a list of towers
    /*private int potentialTowerDamage(Point point) {
        int damage = 0;
        for(Tower tower : towers) {
            if(tower.inRange(point)) {
                damage = tower.getDamage();
            }
        }
        return damage;
    }*/

    private boolean foeReachedEnd(ConcreteFoe foe) { return paths.get(foe).size() == 1; }

    public void placeTower(Tower tower, Point towerPosition) {
        positionalGrid.addTower(tower, towerPosition);
    }
}
