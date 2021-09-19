package alchemydefense.Model;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Model.Wave.Wave;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Board concreteBoard;

    private List<ConcreteFoe> foes = new ArrayList<>();

    public GameModel(){
        concreteBoard = new ConcreteBoard();
    }

    public void placeTowerInCell(Tower.TowerType towerType, Point point) {
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

    public void startNewWave(int boardHeight, PathFinder pathFinder) {
        Wave wave = new Wave();
        foes = wave.createFoes(boardHeight, pathFinder);
    }
}
