package alchemydefense.Model.Towers;

import alchemydefense.Model.Board.BoardObject;

public interface ITower extends BoardObject {
    int getRange();
    int getDamage();

}
