package alchemydefense.Model.Foe;

/**
 * @author Willem Brahmstaedt
 * Interface for representing health.
 *
 * Date: 2021-09-14
 */

public interface Health {
    void takeDamage(int damageCount);

    int getMaxHP();

    int getCurrentHP();

    void setCurrentHP(int hp);

    boolean isAlive();
}
