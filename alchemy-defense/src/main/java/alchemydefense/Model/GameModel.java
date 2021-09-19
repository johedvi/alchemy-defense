package alchemydefense.Model;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.*;
import alchemydefense.Model.Towers.Tower;
import java.io.FileNotFoundException;


import java.awt.*;

/**
 *
 *
 *
 *
 *----- Modified -----
 * Date 09-19, By: Willem; Changed tower creation methods. Now towers no longer know their position.
 *
 */
public class GameModel {
    Board concreteBoard;

    public GameModel(){
        concreteBoard = new ConcreteBoard();
    }

    public void placeTowerInCell(Tower.TowerType towerType, Point point) {
        try {
            Tower tower = createTower(towerType, point);
            concreteBoard.placeBoardObject(tower, point);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }

    public BoardObject getBoardObjectInCell(Point point){
        return concreteBoard.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Point point){
        concreteBoard.removeBoardObject(point);
    }

    private Tower createTower(Tower.TowerType towerType, Point point) throws IllegalArgumentException, FileNotFoundException {
        return TowerFactory.createTower(towerType);
    }
}
