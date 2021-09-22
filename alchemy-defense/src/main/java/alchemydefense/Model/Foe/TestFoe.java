package alchemydefense.Model.Foe;

import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Interfaces.Foe;

public class TestFoe implements Foe, BoardObject {
    @Override
    public void move() {

    }

    @Override
    public void takeDamage(int damageCount) {

    }

    @Override
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getCurrentHP() {
        return 0;
    }

    @Override
    public void setCurrentHP(int hp) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
