package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.ITower;
import alchemydefense.Utility.Vector;

/**
 * Class representing a two-dimensional grid of cells.
 *
 * @author Felix Jönsson
 */
public class TileGrid {
    private final Tile[][] tiles;

    public Tile[][] getGrid(){
        return tiles;
    }


    /**
     * Constructor that instantiates a grid of PositionalCells
     * @param rows the number of rows in the grid.
     * @param columns the number of columns in the grid.
     */
    public TileGrid(int rows, int columns){
        tiles = new Tile[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                Vector coordinatePoint = new Vector(x,y);
                tiles[x][y] = new Tile(coordinatePoint);
            }
        }
    }

    /**
     * Adds a Tower to a specific cell in the grid.
     * @param tower the Tower that should be placed on the grid.
     * @param cell the cell the Tower should be placed on.
     * @return true if Tower is successfully placed on given cell. Otherwise false.
     */
    public boolean addTower(ITower tower, Vector cell){
        if (!tiles[cell.x][cell.y].isOccupiedByTower() && !tiles[cell.x][cell.y].hasFoe()){
            tiles[cell.x][cell.y].addTower(tower);
            return true;
        }
        return false;
    }

    /**
     * Adds a Tower to a specific cell in the grid.
     * @param foe the foe that should be placed on the grid.
     * @param cell cell the cell the Tower should be placed on.
     */
    public void addFoe(Foe foe, Vector cell){
        tiles[cell.x][cell.y].addFoe(foe);
    }

    /**
     * Removes tower from given cell.
     * @param cell the cell that should remove its tower.
     */
    public void remove(Vector cell){
        if(tiles[cell.x][cell.y].isOccupiedByTower()){
            tiles[cell.x][cell.y].setOccupied(false);
            tiles[cell.x][cell.y].clear();
        }
    }

    public Tile getCell(Vector cell){
        return tiles[cell.x][cell.y];
    }

    public BoardObject getBoardObject(Vector cell){
        return tiles[cell.x][cell.y].getBoardObject();
    }

    public ITower getTower(Vector cell) { return tiles[cell.x][cell.y].getTower(); }

}
