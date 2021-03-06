package alchemydefense.Model.Foe;

import alchemydefense.Model.Board.BoardObject;

/**
 * Interface for any object which represents a foe.
 * Extends the Health interface since every foe has health.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */
public interface Foe extends Health, BoardObject {}