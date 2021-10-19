package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Board.BoardObject;

public interface ITower extends BoardObject {
    int getRange();
    int getDamage();

}
