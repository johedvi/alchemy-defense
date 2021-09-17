package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;

import java.awt.*;

public class ConcreteBoard implements Board {
    PositionalGrid positionalGrid;
    final int width = 10;
    final int height = 5;

    public ConcreteBoard(){
        positionalGrid = new PositionalGrid(width, height);
    }

    public BoardObject getBoardObject(Point point){
        return positionalGrid.get(point);
    }

    @Override
    public void placeBoardObject(BoardObject boardObject, Point worldPosition) {
        positionalGrid.add(boardObject, worldPosition);
    }

    public void removeBoardObject(Point point){
        positionalGrid.remove(point);
    }
}
