package alchemydefense.Model.Board;

import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public interface Board {
    void placeBoardObject(Tower boardObject, Point cellCoordinate);
    BoardObject getBoardObject(Point cellCoordinate); // SHOULD RETURN A READ ONLY OBJECT PERHAPS?
    void removeBoardObject(Point cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void updateFoes();
    void addFoe(Foe foe);
    void moveFoes();
    void damageFoes();
    void addPlayerEventListener(PlayerEventListener listener);
}
