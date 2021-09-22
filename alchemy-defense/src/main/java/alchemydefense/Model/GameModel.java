package alchemydefense.Model;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardListener;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Model.Wave.Wave;


import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameModel {
    Board concreteBoard;

    private List<ConcreteFoe> activeFoes = new ArrayList<>();
    private final Set<BoardListener> boardListeners = new HashSet<BoardListener>();

    //TODO: write update method. Moves all foes and makes them take damage, call on placeObjects() in the end

    public GameModel(){
        concreteBoard = new ConcreteBoard();
    }

    public void modelUpdate() {
        //TODO: Fix foes update

        //concreteBoard.updateFoes();

        updateBoardListeners();
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

    public void startNewWave(int boardHeight, PathFinder pathFinder) throws FileNotFoundException {
        Wave wave = new Wave();
        activeFoes = wave.createFoes(boardHeight, pathFinder);
    }

    private boolean isWaveOver() { return activeFoes.isEmpty(); }

    private void updateBoardListeners() {
        for (BoardListener listener : boardListeners)
            listener.placeObjects(concreteBoard);
    }
}
