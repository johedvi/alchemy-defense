package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;

/**
 * Class representing a two-dimensional grid of cells.
 *
 * @author Felix Jönsson
 */
public class PositionalGrid {
    private final PositionalCell[][] positionalCells;

    public PositionalCell[][] getGrid(){
        return positionalCells;
    }

    /**
     * Constructor that instantiates a grid of PositionalCells
     * @param rows the number of rows in the grid.
     * @param columns the number of columns in the grid.
     */
    public PositionalGrid(int rows, int columns){
        positionalCells = new PositionalCell[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                Vector2Int coordinatePoint = new Vector2Int(x,y);
                positionalCells[x][y] = new PositionalCell(coordinatePoint);
            }
        }
    }

    public void add(Tower boardObject, Vector2Int cell){
    /**
     * Adds a BoardObject to a specific cell in the grid.
     * @param boardObject the BoardObject that should be placed on the grid
     * @param cell the cell the BoardObject should be placed on.
     */
    public void add(Tower boardObject, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){
            positionalCells[cell.x][cell.y].addTower(boardObject);
        }
    }


    public boolean addTower(Tower tower, Vector2Int cell){
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){
    /**
     * Adds a Tower to a specific cell in the grid.
     * @param tower the Tower that should be placed on the grid.
     * @param cell the cell the Tower should be placed on.
     * @return true if Tower is successfully placed on given cell. Otherwise false.
     */
    public boolean addTower(Tower tower, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){  //  removed "&& areColRowFree(cell)" //Felix J, could not add towers with this condition, will fix later
            positionalCells[cell.x][cell.y].addTower(tower);
            return true;
        }
        return false;
    }

    public void addFoe(Foe foe, Vector2Int cell){
    /**
     * Adds a Tower to a specific cell in the grid.
     * @param foe the foe that should be placed on the grid.
     * @param cell cell the cell the Tower should be placed on.
     */
    public void addFoe(Foe foe, Point cell){
        positionalCells[cell.x][cell.y].addFoe(foe);
    }

    public void remove(Vector2Int cell){
    /**
     * Checks if the whole row and column are free from towers from a given cell.
     * @param cell the cell that should be tested.
     * @return true if column and row are free from towers. Otherwise false.
     */
    public boolean areColRowFree(Point cell) {
        return isColFree(cell) && isRowFree(cell);
    }

    private boolean isColFree(Point cell) {
        boolean isFree = false;

        for (int i = 0; i < positionalCells[1].length; i++) {
            isFree = isFree || positionalCells[cell.x][i].isOccupiedByTower();
        }

        return isFree;
    }

    private boolean isRowFree(Point cell) {
        boolean isFree = false;

        for (int i = 0; i < positionalCells[0].length; i++) {
            isFree = isFree || positionalCells[i][cell.y].isOccupiedByTower();
        }

        return isFree;
    }

    /**
     * Removes tower from given cell.
     * @param cell the cell that should remove its tower.
     */
    public void remove(Point cell){
        if(positionalCells[cell.x][cell.y].isOccupiedByTower()){
            positionalCells[cell.x][cell.y].setOccupied(false);
            positionalCells[cell.x][cell.y].clear();
        }
    }

    public PositionalCell getCell(Vector2Int cell){
    public PositionalCell[][] getGrid(){
        return positionalCells;
    }

    public PositionalCell getCell(Point cell){
        return positionalCells[cell.x][cell.y];
    }

    public BoardObject getBoardObject(Vector2Int cell){
        return positionalCells[cell.x][cell.y].getBoardObject();
    }

}
