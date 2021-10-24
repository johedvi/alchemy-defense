package alchemydefense.Controller;

import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

/**
 * Interface representing the functionality of a tower controller
 *
 * @author Willem Brahmstaedt
 */
public interface ITowerController {

    /**
     * Creates a Tower at the given cell
     * @param cell Returns the cell on which a Tower shall be put
     */
    void createTower(Vector cell);

    /**
     * Set RedTower as the active Tower
     */
    void setRedTowerActive();
    /**
     * Set BlueTower as the active Tower
     */
    void setBlueTowerActive();

    /**
     * Set GreenTower as the active Tower
     */
    void setGreenTowerActive();

    /**
     * Set PurpleTower as the active Tower
     */
    void setPurpleTowerActive();

    /**
     * Get the currently active Tower
     * @return The current active Tower as a BoardObjectType
     */
    BoardObjectType getActiveTower();

    /**
     * Check if the tower controller currently has an active tower
     * @return Returns a boolean that reflects whether the tower controller has an active tower
     */
    boolean isHoldingTower();

    /**
     * Sets the active Tower to null
     */
    void setHoldingTowerFalse();

    /**
     * Handle user input on a cell
     * @param GRID_WIDTH Width of the view
     * @param GRID_HEIGHT Height of the view
     * @param UNIT_IN_PIXELS Pixel size of one cell
     * @param x X-coordinate of the user input
     * @param y Y-coordinate of the user input
     */
    void cellPressed(int GRID_WIDTH, int GRID_HEIGHT, int UNIT_IN_PIXELS, int x, int y);

    /**
     * Check whether a tower has been pressed on the board
     * @return Boolean representing whether a tower is pressed
     */
    boolean isTowerPressed();

    /**
     * Sell the Tower currently held by the controller
     */
    void sellTower();
}
