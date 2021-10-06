package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Foe.Pathfinding.SlightlyLessDumbPathFinder;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

import java.awt.*;
import java.util.ArrayList;

/**
 * A board that manages a two-dimensional grid where towers and enemies can placed.
 *
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class ConcreteBoard implements Board {
    private final DumbPathfinder pathfinder = new DumbPathfinder(new Point(11, 2));
    private final SlightlyLessDumbPathFinder pf = new SlightlyLessDumbPathFinder(new Point(11, 2));
    private final ArrayList<PositionalCell> cellsWithTowers = new ArrayList<>();
    private final static Player player = Player.getPlayer();
    private PositionalGrid positionalGrid;

    public final int width = 12;
    public final int height = 5;

    /**
     * Constructor that instantiates a new PositionalGrid.
     */
    public ConcreteBoard(){
        positionalGrid = new PositionalGrid(width, height);
    }

    @Override
    public BoardObject getBoardObject(Point point){
        return positionalGrid.getBoardObject(point);
    }

    @Override
    public boolean placeTower(Tower tower, Point cellCoordinate) {
        if(positionalGrid.addTower(tower, cellCoordinate)){
            cellsWithTowers.add(positionalGrid.getCell(cellCoordinate));
            return true;
        }
        return false;
    }

    @Override
    public void removeTower(Point point) {
        cellsWithTowers.remove(positionalGrid.getCell(point));
        positionalGrid.remove(point);
    }

    @Override
    public void addFoe(Foe foe){
        Point startPos = new Point(0, (int) (getBoardHeight() * Math.random()));
        positionalGrid.addFoe(foe, startPos);
    }

    @Override
    public void moveFoes(){
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++) {
                //System.out.print(cellGrid[i][j] + "\t");
                if(cellGrid[i][j].hasFoe() && !((i==11) && (j==2)) && !cellGrid[i][j].hasBeenUpdated){
                    Foe foe = cellGrid[i][j].removeFoe();
                    Point nextCellPoint = pathfinder.calculatePath(null, cellGrid[i][j].getCellCoordinate()).getFirst();
                    //Point nextCellPoint = pf.calculatePath(cellsWithTowers, cellGrid[i][j].getCellCoordinate()).getFirst();
                    positionalGrid.addFoe(foe, nextCellPoint);
                    cellGrid[nextCellPoint.x][nextCellPoint.y].setHasBeenUpdated(true);
                }
            }
        }
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++){
                cellGrid[i][j].setHasBeenUpdated(false);
            }
        }
    }

    @Override
    public void damageFoes(){
        System.out.println("Current active cells with towers: " + cellsWithTowers.toString());
        for(PositionalCell cell : cellsWithTowers){
            int damage = cell.getTower().getDamage();
            ArrayList<PositionalCell> cellsInRange = cell.getPositionalCellsWithinRange(this);
            for(PositionalCell cellInRange : cellsInRange){
                if(cellInRange.hasFoe()){
                    cellInRange.getFoe().takeDamage(damage);
                    if(!cellInRange.getFoe().isAlive()) {
                        cellInRange.removeFoe();
                        player.increaseGold(5);
                    }
                }
            }
        }
    }

    @Override
    public void addPlayerEventListener(PlayerEventListener listener) {
        player.addPlayerEventListener(listener);
    }

    @Override
    public int getBoardWidth() { return width; }

    @Override
    public int getBoardHeight() { return height; }

    public PositionalCell getCell(Point point){ return positionalGrid.getCell(point); }
}
