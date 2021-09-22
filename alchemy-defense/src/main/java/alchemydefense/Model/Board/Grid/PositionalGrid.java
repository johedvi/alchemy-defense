package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public class PositionalGrid {
    PositionalCell[][] positionalCells;

    public PositionalGrid(int rows, int columns){
        positionalCells = new PositionalCell[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                Point coordinatePoint = new Point(x,y);
                positionalCells[x][y] = new PositionalCell(coordinatePoint);
            }
        }
    }

    public void add(BoardObject boardObject, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupied()){
            positionalCells[cell.x][cell.y].insert(boardObject);
        }
    }

    public void addTower(Tower tower, Point cell){
        if (!positionalCells[cell.x][cell.y].isOccupied()){
            positionalCells[cell.x][cell.y].insertTower(tower);
        }
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
