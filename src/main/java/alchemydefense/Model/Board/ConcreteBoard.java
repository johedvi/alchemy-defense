package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Foe.Pathfinding.SlightlyLessDumbPathFinder;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;

import java.awt.*;
import java.util.ArrayList;

/**
 * A board that manages a two-dimensional grid where towers and enemies can placed.
 *
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class ConcreteBoard implements Board {

    private final DumbPathfinder pathfinder = new DumbPathfinder(new Vector2Int(11, 2));

    private final ArrayList<PositionalCell> cellsWithTowers = new ArrayList<>();
    private final static Player player = Player.getPlayer();

    private final PositionalGrid positionalGrid;
    public final int width = 12;
    public final int height = 5;
    public final int endgoalX = 11;
    public final int endgoalY = 2;

    /**
     * Constructor that instantiates a new PositionalGrid.
     */
    public ConcreteBoard(){
        positionalGrid = new PositionalGrid(width, height);
    }

    public BoardObject getBoardObject(Vector2Int point){
        return positionalGrid.getBoardObject(point);
    }

    public PositionalCell getCell(Vector2Int point){
        return positionalGrid.getCell(point);
    }

    @Override
    public void placeTower(Tower boardObject, Vector2Int worldPosition) {
        if(positionalGrid.addTower(boardObject, worldPosition)){
            cellsWithTowers.add(positionalGrid.getCell(worldPosition));
        }
    }

    public void removeBoardObject(Vector2Int point) {
        cellsWithTowers.remove(positionalGrid.getCell(point));
        positionalGrid.remove(point);
    }

    @Override
    public int getBoardWidth() {
        return width;
    }

    @Override
    public int getBoardHeight() {
        return height;
    }

    @Override
    public void updateFoes() {
        damageFoes();
        moveFoes();
    }

    public void addFoe(Foe foe){
        Vector2Int startPos = new Vector2Int(0, (int) (getBoardHeight() * Math.random()));
        positionalGrid.addFoe(foe, startPos);
    }

    public void foeReachedEnd() {
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        if(cellGrid[endgoalX][endgoalY].hasFoe()) {
           cellGrid[endgoalX][endgoalY].removeFoe();
            player.decreaseOneHp();

        }

    }

    @Override
    public void moveFoes(){
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++) {
                if(cellGrid[i][j].hasFoe() && !(i==11 && j==2) && !cellGrid[i][j].isUpdated()){
                    Foe foe = cellGrid[i][j].removeFoe();
                    Vector2Int nextCellPoint = pathfinder.calculatePath(null, cellGrid[i][j].getCellCoordinate()).getFirst();
                    positionalGrid.addFoe(foe, nextCellPoint);
                    cellGrid[nextCellPoint.x][nextCellPoint.y].setUpdated(true);
                }
            }
        }
        for (PositionalCell[] positionalCells : cellGrid) {
            for (PositionalCell positionalCell : positionalCells) {
                positionalCell.setUpdated(false);
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
}
