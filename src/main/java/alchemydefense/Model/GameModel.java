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
import alchemydefense.Utility.Vector2Int;

import java.util.LinkedList;
import java.util.HashSet;

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
    private final Board board;

    private LinkedList<Foe> activeFoes = new LinkedList<>();
    private final HashSet<BoardListener> boardListeners = new HashSet<>();

    public GameModel(){
        startNewWave();
        board = new ConcreteBoard();
    }

    public void modelUpdate() {

        if (isWaveOver())
            startNewWave();
        else
            board.addFoe(activeFoes.removeFirst());

        board.updateFoes();


    }

    // ------- Create and place tower -------
    public void placeTowerInCell(TowerType towerType, Vector2Int point) {
        try {
            Tower tower = buyTower(towerType);
            board.placeTower(tower, point);
        }
        catch (Exception e){
            System.out.println("Not able to create the tower mentioned. Error: " + e.getMessage());
        }
    }


    private Tower buyTower(TowerType towerType) throws Exception {
        return new TowerTransaction().buyTower(towerType);
    }

    public void sellTower(Vector2Int point, TowerType towerType) {
        board.removeBoardObject(point);
        new TowerTransaction().sellTower(towerType);
    }

    // ------- Handling of BoardObjects -------
    public BoardObject getBoardObjectInCell(Vector2Int point){
        return board.getBoardObject(point);
    }

    public void removeBoardObjectInCell(Vector2Int point){
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

        //TODO: Scuffed fix, have to fix how foes render at the end point.
        board.foeReachedEnd();
    }
}
