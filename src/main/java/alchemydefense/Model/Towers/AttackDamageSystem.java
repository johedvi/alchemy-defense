package alchemydefense.Model.Towers;

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
