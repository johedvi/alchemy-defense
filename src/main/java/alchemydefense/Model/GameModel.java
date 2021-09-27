package alchemydefense.Model;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.*;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Model.Wave.Wave;
import java.io.FileNotFoundException;


import java.awt.*;
import java.util.*;

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
    ConcreteBoard concreteBoard;

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final Set<BoardListener> boardListeners = new HashSet<BoardListener>();

    //TODO: write update method. Moves all foes and makes them take damage, call on placeObjects() in the end

    public GameModel(){
        startNewWave();
        concreteBoard = new ConcreteBoard();
    }

    public void modelUpdate() {

        if (isWaveOver())
            startNewWave();
        else
            concreteBoard.addFoe(activeFoes.removeFirst());
        //concreteBoard.updateFoes();
        concreteBoard.damageMethod();
        concreteBoard.moveFoes();
        updateBoardListeners();
    }

    public void placeTowerInCell(Tower.TowerType towerType, Point point) {
        try {
            Tower tower = createTower(towerType, point);
            concreteBoard.placeBoardObject(tower, point); // tar bort för tillfället
            //concreteBoard.placeTower(tower,point);
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

    public void startNewWave() {
        Wave wave = new Wave();
        activeFoes = wave.createFoes();
    }

    private boolean isWaveOver() { return activeFoes.isEmpty(); }

    private void updateBoardListeners() {
        for (BoardListener listener : boardListeners)
            listener.placeObjects(concreteBoard);
    }

    public void addBoardListener(BoardListener listener) {
        boardListeners.add(listener);
    }

    public void addPlayerEventListener(PlayerEventListener listener) { concreteBoard.addPlayerEventListener(listener);}
}
