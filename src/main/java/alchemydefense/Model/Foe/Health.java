package alchemydefense.Model.Foe;

/**
 * Interface for representing health.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */

public interface Health {

    /**
     * Deals damage equal to damageCount.
     * @param damageCount the damage that should be taken.
     */
    void takeDamage(int damageCount);

    int getMaxHP();

    int getCurrentHP();

    void setCurrentHP(int hp);

    boolean isAlive();
}
