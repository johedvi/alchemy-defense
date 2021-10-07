package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;

import java.util.ArrayList;

/**
 * Class representing a cell in a grid.
 *
 * @author Felix Jönsson
 */
public class PositionalCell {
    private final Vector cellCoordinate;
    private boolean isOccupiedByTower = false;
    private Tower tower;
    private Foe foe;
    private boolean updated = false;

    /**
     * Overloaded constructor that instantiates a cell with given coordinates.
     * @param x the x-coordinate of the cell.
     * @param y the y-coordinate of the cell.
     */
    public PositionalCell(int x, int y){
        cellCoordinate = new Vector(x,y);
    }

    /**
     * Overloaded constructor that instantiates a cell with a given point.
     * @param point the point that represents the coordinates of the cell.
     */
    public PositionalCell(Vector point){
        cellCoordinate = point;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupiedByTower = isOccupied;
    }
    public void setUpdated(boolean b){
        updated = b;
    }

    public boolean hasFoe(){
        return foe != null;
    }
    public boolean isOccupiedByTower() {
        return isOccupiedByTower;
    }

    public Vector getCellCoordinate(){
        return cellCoordinate;
    }
    public boolean isUpdated() { return updated; }

    public BoardObject getBoardObject(){
        if(tower != null){
            return tower;
        }
        else if(foe != null){
            return foe;
        }
        return null;
    }

    public Tower getTower(){
        return tower;
    }
    public Foe getFoe(){
        return foe;
    }

    /**
     * Places a tower on the cell.
     * @param tower the tower that is placed on the cell.
     */
    public void addTower(Tower tower) {
        if(isOccupiedByTower) return;
        isOccupiedByTower = true;
        this.tower = tower;
    }

    /**
     * Clears a cell from all objects on it.
     */
    public void clear(){
        foe = null;
        tower = null;
        isOccupiedByTower = false;
    }

    /**
     * If the cell contains a tower it checks which other cells is within range from the tower.
     * @param board the board that holds the grid of cells.
     * @return an ArrayList of all other PositionalCells within range of this PositionalCells tower.
     */
    public ArrayList<PositionalCell> getPositionalCellsWithinRange(ConcreteBoard board){
        ArrayList<PositionalCell> cellsInRange = new ArrayList<>();

        if(tower == null || tower.getRange() == 0){
           return cellsInRange;
        }

        int range = tower.getRange();

        for (int y = -range; y <= range; y++) {
            for (int x = -range; x <= range ; x++) {
                if(x == 0 && y == 0){
                    continue;
                }
                if(Math.abs(x) + Math.abs(y) > range){
                    continue;
                }
                Vector currentCellPosition = new Vector(cellCoordinate.x + x, cellCoordinate.y + y);
                if(currentCellPosition.x >= 0 && currentCellPosition.x < board.width &&
                currentCellPosition.y >= 0 && currentCellPosition.y < board.height){
                    cellsInRange.add(board.getCell(currentCellPosition));
                }
            }
        }
        return cellsInRange;
    }

    public Foe removeFoe(){
        Foe foe = this.foe;
        clear();
        return foe;
    }

    //Allow multiple foes? Possible solution = store foes as a list.
    public void addFoe(Foe foe){
        if(!hasFoe()){
            this.foe = foe;
        }
    }

    @Override
    public String toString(){
        return "(" + cellCoordinate.x + ", " + cellCoordinate.y + ")";
    }
}
