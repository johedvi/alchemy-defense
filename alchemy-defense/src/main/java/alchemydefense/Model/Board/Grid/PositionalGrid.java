package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Interfaces.BoardObject;

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

    public void remove(Point cell){
        if(positionalCells[cell.x][cell.y].isOccupied()){
            positionalCells[cell.x][cell.y].setOccupied(false);
            positionalCells[cell.x][cell.y].clear();
        }
    }

    public BoardObject get(Point cell){
        return positionalCells[cell.x][cell.y].getBoardObject();
    }
}
