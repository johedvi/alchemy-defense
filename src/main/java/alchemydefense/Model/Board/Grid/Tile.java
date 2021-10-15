package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.ITower;
import alchemydefense.Utility.Vector;

import java.util.ArrayList;

/**
 * Class representing a cell in a grid.
 *
 * @author Felix Jönsson
 */
public class Tile {
    private final Vector cellCoordinate;
    private boolean isOccupiedByTower = false;
    private ITower tower;
    private Foe foe;
    private boolean updated = false;

    /**
     * Overloaded constructor that instantiates a cell with given coordinates.
     * @param x the x-coordinate of the cell.
     * @param y the y-coordinate of the cell.
     */
    public Tile(int x, int y){
        cellCoordinate = new Vector(x,y);
    }

    /**
     * Overloaded constructor that instantiates a cell with a given point.
     * @param point the point that represents the coordinates of the cell.
     */
    public Tile(Vector point){
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

    public ITower getTower(){
        return tower;
    }
    public Foe getFoe(){
        return foe;
    }

    /**
     * Places a tower on the cell.
     * @param tower the tower that is placed on the cell.
     */
    public void addTower(ITower tower) {
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

    public ArrayList<Tile> getPositionalCellsWithinRange(Board board){
        ArrayList<Tile> cellsInRange = new ArrayList<>();

        if(tower == null || tower.getRange() == 0){
           return cellsInRange;
        }

        addCellsWithinRange(cellsInRange, board);

        return cellsInRange;
    }

    private void addCellsWithinRange(ArrayList<Tile> cellsInRange, Board board) {
        int range = tower.getRange();

        for (int y = -range; y <= range; y++) {
            for (int x = -range; x <= range ; x++) {
                if(x == 0 && y == 0){
                    continue;
                }
                if(Math.abs(x) + Math.abs(y) > range){
                    continue;
                }
                addCell(cellsInRange, board, x, y);

            }
        }
    }

    private void addCell(ArrayList<Tile> cellsInRange, Board board, int x, int y) {
        Vector currentCellPosition = new Vector(cellCoordinate.x + x, cellCoordinate.y + y);
        if(currentCellPosition.x >= 0 && currentCellPosition.x < board.getBoardWidth() &&
                currentCellPosition.y >= 0 && currentCellPosition.y < board.getBoardHeight()){
            cellsInRange.add(board.getCell(currentCellPosition));
        }
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
