package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public class PositionalGrid {
    PositionalCell[][] positionalCells;

    public PositionalCell[][] getGrid(){
        return positionalCells;
    }


    public PositionalGrid(int rows, int columns){
        positionalCells = new PositionalCell[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                Point coordinatePoint = new Point(x,y);
                positionalCells[x][y] = new PositionalCell(coordinatePoint);
            }
        }
    }

    public void add(Tower boardObject, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){
            positionalCells[cell.x][cell.y].addTower(boardObject);
        }
    }


    public boolean addTower(Tower tower, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){  //  removed "&& areColRowFree(cell)" //Felix J, could not add towers with this condition, will fix later
            positionalCells[cell.x][cell.y].addTower(tower);
            return true;
        }
        return false;
    }

    public void addFoe(Foe foe, Point cell){
        positionalCells[cell.x][cell.y].addFoe(foe);
    }

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

    public void remove(Point cell){
        if(positionalCells[cell.x][cell.y].isOccupiedByTower()){
            positionalCells[cell.x][cell.y].setOccupied(false);
            positionalCells[cell.x][cell.y].clear();
        }
    }

    public PositionalCell getCell(Point cell){
        return positionalCells[cell.x][cell.y];
    }

    public BoardObject getBoardObject(Point cell){
        return positionalCells[cell.x][cell.y].getBoardObject();
    }

    //Temporary
    //public Tower getTower(Point cell) { return positionalCells[cell.x][cell.y].getTower(); }
}
