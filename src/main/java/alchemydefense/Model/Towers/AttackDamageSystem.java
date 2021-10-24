package alchemydefense.Model.Towers;

/**
 * A class for a AttackDamageSystem. Represents all the data for how a Boardobject attacks.
 *
 * @author Johan Lindén
 *
 * Date: 2021-09-26
 */
public class AttackDamageSystem {
    private final int range;
    private final int damage;

    public AttackDamageSystem(int range, int damage) {
        this.range = range;
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
}
