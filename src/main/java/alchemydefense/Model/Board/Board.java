package alchemydefense.Model.Board;

import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

import java.awt.*;

/**
 * Interface for the board.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */

public interface Board {
    boolean placeTower(Tower boardObject, Point cellCoordinate);
    BoardObject getBoardObject(Point cellCoordinate); // SHOULD RETURN A READ ONLY OBJECT PERHAPS?
    void removeTower(Point cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void addFoe(Foe foe);
    void moveFoes();
    void damageFoes();
    void addPlayerEventListener(PlayerEventListener listener);
}
