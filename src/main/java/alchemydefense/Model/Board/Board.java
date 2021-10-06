package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;

public interface Board {
    void placeTower(Tower boardObject, Vector2Int cellCoordinate);
    BoardObject getBoardObject(Vector2Int cellCoordinate);
    PositionalCell getCell(Vector2Int cellPosition);
    void removeBoardObject(Vector2Int cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void updateFoes();
    void addFoe(Foe foe);

    void moveFoes();
    void damageFoes();
    void addPlayerEventListener(PlayerEventListener listener);

    void foeReachedEnd();
}
