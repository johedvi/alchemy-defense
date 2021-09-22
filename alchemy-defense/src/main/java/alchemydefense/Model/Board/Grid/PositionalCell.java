package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Interfaces.BoardObject;

import java.awt.*;

public class PositionalCell {
    final Point cellCoordinate;
    final Point worldPosition;
    private boolean isOccupied = false;
    private BoardObject boardObject;

    PositionalCell(Point point){
        cellCoordinate = point;
        worldPosition = convertCellPositionToWorld(cellCoordinate);
    }

    public void insert(BoardObject boardObject) {
        isOccupied = true;
        this.boardObject = boardObject;
    }

    public BoardObject getBoardObject(){
        return boardObject;
    }

    public Point getCellWorldPosition(){
        return worldPosition;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    public void clear(){
        boardObject = null;
        isOccupied = false;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    private Point convertCellPositionToWorld(Point cellPosition){
        int cellWorldWidth = 64;                                    //<<<<<<<< NEEDS REFACTORING
        int cellWorldHeight = 64;

        return new Point(cellWorldWidth * cellCoordinate.x, cellWorldHeight * cellCoordinate.y);
    }
}
