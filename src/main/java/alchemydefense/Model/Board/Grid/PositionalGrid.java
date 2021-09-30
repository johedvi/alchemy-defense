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
        if (!positionalCells[cell.x][cell.y].isOccupied()){
            positionalCells[cell.x][cell.y].addTower(boardObject);
        }

    }

    public void addTower(Tower tower, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupied() && areColRowFree(cell)){
            positionalCells[cell.x][cell.y].addTower(tower);
        }
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
            isFree = isFree || positionalCells[cell.x][i].isOccupied();
        }

        return isFree;
    }

    private boolean isRowFree(Point cell) {
        boolean isFree = false;

        for (int i = 0; i < positionalCells[0].length; i++) {
            isFree = isFree || positionalCells[i][cell.y].isOccupied();
        }

        return isFree;
    }

    public void remove(Point cell){
        if(positionalCells[cell.x][cell.y].isOccupied()){
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
}
