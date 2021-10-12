package alchemydefense.Model;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.*;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Model.Wave.Wave;
import alchemydefense.Model.Wave.WaveListener;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

import java.util.LinkedList;
import java.util.HashSet;

/**
 * Acts as a facade for the model domain. Supplies necessary functionality
 * to set up and modify the game. Contains all the logic.
 *
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class GameModel {
    private final Board board;

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final HashSet<BoardListener> boardListeners = new HashSet<>();

    private static boolean gamePaused = true;

    /**
     * Constructor that instantiates a new board and starts the first wave.
     */
    public GameModel(){
        board = new ConcreteBoard();
    }

    /**
     * Updates the whole model.
     */
    public void modelUpdate() {
        if(!isGamePaused()) {
            if (isWaveOver())
                startNewWave();
            else {
                board.addFoe(activeFoes.removeFirst());
                if(activeFoes.isEmpty()) {
                    gamePaused = true;
                }
            }
        }
        board.foeReachedEnd();
        board.updateFoes();
    }

    // ------- Create and place tower -------

    /**
     * Creates a new tower from if the player has sufficient gold.
     * Will throw an exception if tower the construction failed.
     * @param boardObjectType tower type to construct.
     * @param point tile coordinate to place the tower in.
     */
    public void placeTowerInCell(BoardObjectType boardObjectType, Vector point) {
        try {
            Tower tower = buyTower(boardObjectType);
            board.placeTower(tower, point);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }

    private Tower buyTower(BoardObjectType boardObjectType) throws Exception {
        return new TowerTransaction().buyTower(boardObjectType);
    }

    /**
     * Sells the tower and returns a set amount of gold to the player. The transaction is handled by an internal class.
     * @param point tile position of the tower.
     */
    public void sellTower(Vector point) {
        BoardObjectType boardObjectType = board.getBoardObject(point).getBoardObjectType();
        board.removeTower(point);
        new TowerTransaction().sellTower(boardObjectType);
    }

    // ------- Handling of BoardObjects -------
    public BoardObject getBoardObjectInCell(Vector point){
        return board.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Vector point){
        board.removeTower(point);
    }

    // ------- Wave methods -------
    public void startNewWave() {
        if(isWaveOver()) {
            gamePaused = false;
            activeFoes = new Wave().createFoes();
        }
    }

    public void addWaveListener(WaveListener listener) { Wave.addWaveListener(listener);}

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

    public boolean isGamePaused() { return gamePaused; }
}
