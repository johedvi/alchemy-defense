package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.Tile;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector;

/**
 * Interface for a board.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */
public interface Board {


    /**
     * Place a tower in the specified tile if the tile is empty.
     * @param tower the tower that should be placed on the board.
     * @param cellCoordinate the cell tha tower should be placed in.
     */
    void placeTower(Tower tower, Vector cellCoordinate);

    /**
     * Removes BoardObject from a given cell.
     * @param cellCoordinate the cell that should remove its tower.
     */
    void removeBoardObject(Vector cellCoordinate);

    /**
     * Adds the given foe to a random tile in the first column of the game. Foes should enter from the leftmost column.
     * @param foe the foe that should be added on the board.
     */
    void addFoe(Foe foe);

    /**
     * Moves all foes one step on the board.
     */
    void moveFoes();

    /**
     * Damage all foes that are in range of a tower.
     */
    void damageFoes();

    BoardObject getBoardObject(Vector cellCoordinate);

    int getBoardWidth();

    int getBoardHeight();

    void updateFoes();

    void addPlayerEventListener(PlayerEventListener listener);

    void foeReachedEnd();

    Tile getCell(Vector cell);

    Tower getTower(Vector cell);
}
