package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;
import java.util.ArrayList;

public class ConcreteBoard implements Board {

    private final DumbPathfinder pathfinder = new DumbPathfinder(new Point(11, 2));

    private final ArrayList<PositionalCell> cellsWithTowers = new ArrayList<>();

    private final static Player player = Player.getPlayer();

    PositionalGrid positionalGrid;
    public final int width = 12;
    public final int height = 5;

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
    public void placeBoardObject(BoardObject boardObject, Point worldPosition) {
        positionalGrid.add(boardObject, worldPosition);
        if(boardObject instanceof Tower){
            cellsWithTowers.add(positionalGrid.getCell(worldPosition));
        }
    }

    public void removeBoardObject(Point point){
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
        //TODO: Make foes move and then take damage
    }

    public void addFoe(Foe foe){
        Point startPos = new Point(0, (int) (getBoardHeight() * Math.random()));
        positionalGrid.addFoe(foe, startPos);
    }

    public void moveFoes(){
        PositionalCell[][] cellGrid = positionalGrid.getGrid();
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++) {
                //System.out.print(cellGrid[i][j] + "\t");
                if(cellGrid[i][j].hasFoe() && !((i==11) && (j==2)) && !cellGrid[i][j].hasBeenUpdated){
                    Foe foe = cellGrid[i][j].removeFoe();
                    Point nextCellPoint = pathfinder.calculatePath(null, cellGrid[i][j].getCellCoordinate()).getFirst();
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

    public void addPlayerEventListener(PlayerEventListener listener) {
        player.addPlayerEventListener(listener);
    }
}
