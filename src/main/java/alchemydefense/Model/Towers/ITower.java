package alchemydefense.Model.Towers;

import alchemydefense.Model.Board.BoardObject;

/**
 * Interface for any object which represents a Tower.
 *
 * @author Johan linden
 *
 * Date: 2021-09-14
 */


public interface ITower extends BoardObject {
    int getRange();

    int getDamage();

    int getBuyPrice();

    int getSellPrice();

}