package alchemydefense.Model;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.*;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Model.Wave.Wave;

import java.awt.*;
import java.util.*;

/**
 * Acts as a facade for the model domain. Supplies necessary functionality
 * to set up and modify the game. Contains all the logic.
 *
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class GameModel {
    Board board;

    private final Player player = Player.getPlayer();

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final Set<BoardListener> boardListeners = new HashSet<>();

    public GameModel(){
        startNewWave();
        board = new ConcreteBoard();
    }


    /**
     * TODO
     *
     *
     */
    public void modelUpdate() {
        updateWave();
        board.damageFoes();
        board.moveFoes();
        updateBoardListeners();
    }

    private void updateWave() {
        if (isWaveOver())
            startNewWave();
        else
            board.addFoe(activeFoes.removeFirst());
    }

    /**
     * Creates a new tower from if the player has sufficient gold.
     * Will throw an exception if tower the construction failed.
     * @param towerType tower type to construct.
     * @param coordinate tile coordinate to place the tower in.
     */
    public void placeTowerInCell(TowerType towerType, Point coordinate) {
        try {
            Tower tower = buyTower(towerType);
            board.placeTower(tower, coordinate);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }

    private Tower buyTower(TowerType towerType) throws Exception {
        return new TowerTransaction().buyTower(towerType);
    }

    public void sellTower(Point point, TowerType towerType) {
        board.removeBoardObject(point);
        new TowerTransaction().sellTower(towerType);
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

    public void updateBoardListeners() {
        for (BoardListener listener : boardListeners)
            listener.renderObjects(board);
    }
}
