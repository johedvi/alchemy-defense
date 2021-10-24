package alchemydefense.Model;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Towers.TowerStatListener;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

/**
 * Interface for handling of Towers.
 *
 * @author Willem Brahmstaedt
 */
public interface ITowerHandler {

    /**
     * Places a BoardObject of specified type on the given cell
     *
     * @param boardObjectType The type of BoardObject that shall be placed
     * @param cell            The cell on which the BoardObject shall be placed
     */
    void placeTowerInCell(BoardObjectType boardObjectType, Vector cell);

    /**
     * Sells the Tower on the given cell
     *
     * @param cell Location of the Tower that shall be sold
     */
    void sellTower(Vector cell);

    /**
     * Getter for a BoardObject in a given cell
     *
     * @param cell Cell from which the BoardObject is taken
     * @return The BoardObject from the given cell
     */
    BoardObject getBoardObjectInCell(Vector cell);

    /**
     * Updates all TowerStatListeners
     * @param cell The cell on which the tower in question is placed
     */
    void updateTowerStatListeners(Vector cell);

    /**
     * Add a TowerStatListener, so it will be updated in the future
     * @param tsl TowerStatListener that shall be added
     */
    void addTowerStatListener(TowerStatListener tsl);
}
