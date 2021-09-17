package alchemydefense.Model;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.RedTower;
import alchemydefense.Model.Towers.Tower;


import java.awt.*;

public class GameModel {
    Board concreteBoard;

    public GameModel(){
        concreteBoard = new ConcreteBoard();
    }

    public void placeTowerInCell(Point point) {
        Tower tower = createTower();
        concreteBoard.placeBoardObject(tower, point);
    }

    public BoardObject getBoardObjectInCell(Point point){
        return concreteBoard.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Point point){
        concreteBoard.removeBoardObject(point);
    }

    private Tower createTower(){
        //TODO
        return null;
    }
}
