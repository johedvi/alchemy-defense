package alchemydefense.Model;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.*;

import alchemydefense.Model.Foe.Wave;
import alchemydefense.Model.Foe.WaveListener;

import alchemydefense.Model.Towers.ITower;

import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

import java.util.LinkedList;
import java.util.HashSet;

/**
 * Acts as a facade for the model domain. Supplies necessary functionality
 * to set up and modify the game. Contains all the logic.
 *
 * @author Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class GameModel implements ITowerHandler, IWaveHandler {
    private final Board board;
    private final Player currentPlayer;

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final HashSet<BoardListener> boardListeners = new HashSet<>();

    private final HashSet<TowerStatListener> towerStatListeners = new HashSet<>();

    private static boolean gamePaused = true;
    private static boolean firstIteration = true;

    /**
     * Constructor that instantiates a new board and starts the first wave.
     * @param width the width of the board.
     * @param height the height of the board.
     */
    public GameModel(int width, int height) {
        this.currentPlayer = new Player(100, 100);
        this.board = new ConcreteBoard(this.currentPlayer, width, height);
    }

    /**
     * Updates the whole model.
     */
    public void modelUpdate() {
        if (firstIteration) {
            board.updateFoes();
            board.foeReachedEnd();
            firstIteration = false;
        }
        else {
            board.foeReachedEnd();
            board.updateFoes();
        }

        if(!isGamePaused()) {
            if (isWaveOver()) {
                startNewWave();
            }
            else {
                board.addFoe(activeFoes.removeFirst());
                if(activeFoes.isEmpty()) {
                    gamePaused = true;
                }
            }
        }

    }

    // ------- Create and place tower -------

    /**
     * Creates a new tower from if the player has sufficient gold.
     * Will throw an exception if tower the construction failed.
     * @param boardObjectType tower type to construct.
     * @param point tile coordinate to place the tower in.
     */
    @Override
    public void placeTowerInCell(BoardObjectType boardObjectType, Vector point) {
        try {
             ITower tower = createTower(boardObjectType);
             buyTower(tower, currentPlayer);
            board.placeTower(tower, point);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }

    public ITower createTower (BoardObjectType boardObjectType) {
        return TowerFactory.createTower(boardObjectType);
    }


    private ITower buyTower(ITower tower, Player currentPlayer) throws Exception {
        return TowerTransaction.buyTower(tower, currentPlayer);

    }

    /**
     * Sells the tower and returns a set amount of gold to the player. The transaction is handled by an internal class.
     * @param point tile position of the tower.
     */
    @Override
    public void sellTower(Vector point) {
        ITower tower = board.getTower(point);
        board.removeTower(point);

        TowerTransaction.sellTower(tower,currentPlayer);

    }

    // ------- Handling of BoardObjects -------
    @Override
    public BoardObject getBoardObjectInCell(Vector point){
        return board.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Vector point){
        board.removeTower(point);
    }

    // ------- Wave methods -------
    @Override
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

    // ------- TowerStatListener -------
    @Override
    public void addTowerStatListener(TowerStatListener tsl) { this.towerStatListeners.add(tsl); }

    @Override
    public void updateTowerStatListeners(Vector cell) {
        ITower tower = board.getTower(cell);
        for(TowerStatListener listener : towerStatListeners) {
            listener.displayTowerStats(tower.getBoardObjectType().toString(), tower.getRange(), tower.getDamage(),
                    tower.getSellPrice());
        }
    }

    public boolean isGamePaused() { return gamePaused; }

    public Board getBoard() { return board; }
}
