package alchemydefense.Model.Foe;

import alchemydefense.Model.Board.BoardObject;

/**
 * @author Willem Brahmstaedt
 * Interface for any object which represents a foe. Uses Marker Interface Pattern.
 * Extends the Health interface since every foe has health.
 *
 * Date: 2021-09-14
 */

public interface Foe extends Health, BoardObject {
}
