package alchemydefense.Model.Board;

import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

import java.awt.Point;

public interface Board {
    void placeTower(Tower boardObject, Point cellCoordinate);
    BoardObject getBoardObject(Point cellCoordinate);
    void removeBoardObject(Point cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void updateFoes();
    void addFoe(Foe foe);
    void moveFoes();
    void damageFoes();
    void addPlayerEventListener(PlayerEventListener listener);
}
