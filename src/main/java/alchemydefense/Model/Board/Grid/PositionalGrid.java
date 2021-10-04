package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

import java.awt.Point;

public class PositionalGrid {
    private final PositionalCell[][] positionalCells;

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
        if (!positionalCells[cell.x][cell.y].isOccupiedByTower()){
            positionalCells[cell.x][cell.y].addTower(tower);
            return true;
        }
        return false;
    }

    public void addFoe(Foe foe, Point cell){
        positionalCells[cell.x][cell.y].addFoe(foe);
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

}
