package alchemydefense.Model;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
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

    private final Player player = Player.getPlayer();
    Board board;

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final Set<BoardListener> boardListeners = new HashSet<>();

    public GameModel(){
        startNewWave();
        board = new ConcreteBoard();
    }

    public void modelUpdate() {

        if (isWaveOver())
            startNewWave();
        else
            board.addFoe(activeFoes.removeFirst());

        board.damageFoes();
        board.moveFoes();
        updateBoardListeners();
    }

    // ------- Create and place tower -------
    public void placeTowerInCell(Tower.TowerType towerType, Point point) {
        try {
            Tower tower = buyTower(towerType);
            board.placeTower(tower, point);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }

    //TODO Should GameModel really have a player or is it enough that ConcreteBoard has one?
    private Tower buyTower(Tower.TowerType towerType) throws Exception {
        int price = TowerTransaction.getBuyPrice(towerType);
        if(player.canAfford(price)) {
            player.pay(price);
            return new TowerTransaction().buyTower(towerType);
        }
        throw new Exception("Not enough gold.");
    }

    // ------- Handling of BoardObjects -------
    public BoardObject getBoardObjectInCell(Point point){
        return board.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Point point){
        board.removeBoardObject(point);
    }

    // ------- Wave methods -------
    public void startNewWave() {
        Wave wave = new Wave();
        activeFoes = wave.createFoes();
    }

    private boolean isWaveOver() { return activeFoes.isEmpty(); }

    // ------- PlayerEventListener -------
    public void addPlayerEventListener(PlayerEventListener listener) { board.addPlayerEventListener(listener);}

    // ------- BoardListener -------
    public void addBoardListener(BoardListener listener) {
        boardListeners.add(listener);
    }

    private void updateBoardListeners() {
        for (BoardListener listener : boardListeners)
            listener.renderObjects(board);
    }
}
