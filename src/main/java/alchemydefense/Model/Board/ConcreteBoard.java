package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

import java.awt.Point;
import java.util.ArrayList;

public class ConcreteBoard implements Board {

    private final DumbPathfinder pathfinder = new DumbPathfinder(new Point(11, 2));

    private final ArrayList<PositionalCell> cellsWithTowers = new ArrayList<>();

    private final static Player player = Player.getPlayer();

    private final PositionalGrid positionalGrid;
    public final int width = 12;
    public final int height = 5;
    public final int endgoalX = 11;
    public final int endgoalY = 2;

    public void damageFoes(){
        for(PositionalCell cell : cellsWithTowers){
            ArrayList<PositionalCell> cellsInRange = cell.getPositionalCellsWithinRange(this);
            for(PositionalCell cellInRange : cellsInRange){
                if(cellInRange.hasFoe()){
                    int damage = cell.getTower().getDamage();
                    cellInRange.getFoe().takeDamage(damage);
                    if(!cellInRange.getFoe().isAlive()) {
                        cellInRange.removeFoe();
                        player.increaseGold(5);
                    }
                }
            }
        }
    }

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
    public void placeTower(Tower boardObject, Point worldPosition) {
        if(positionalGrid.addTower(boardObject, worldPosition)){
            cellsWithTowers.add(positionalGrid.getCell(worldPosition));
        }
    }

    public void removeBoardObject(Point point) {
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
        Point startPos = new Point(0, (int) (getBoardHeight() * Math.random()));
        positionalGrid.addFoe(foe, startPos);
    }

    public void foeReachedEnd() {
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        if(cellGrid[endgoalX][endgoalY].hasFoe()) {
           cellGrid[endgoalX][endgoalY].removeFoe();
            player.decreaseOneHp();

        }

    }

    public void moveFoes(){
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++) {
                if(cellGrid[i][j].hasFoe() && !(i==11 && j==2) && !cellGrid[i][j].isUpdated()){
                    Foe foe = cellGrid[i][j].removeFoe();
                    Point nextCellPoint = pathfinder.calculatePath(null, cellGrid[i][j].getCellCoordinate()).getFirst();
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

    public void addPlayerEventListener(PlayerEventListener listener) {
        player.addPlayerEventListener(listener);
    }
}
