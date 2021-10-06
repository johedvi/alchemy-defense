package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Towers.TowerType;

/**
 * Class representing a concrete Redtower. Extends Tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-22
 *
 */

public class PurpleTower extends Tower {
    private static final String imageFilePath = "/purple-crystal.png";
    private static final int purpleTowerRange = 3;
    private static final int purpleTowerDamage = 10;


    /**
     * Constructor for PurpleTower.
     * @see Tower for call to super.
     */
    public PurpleTower() {
        super(TowerType.PURPLE, imageFilePath, purpleTowerRange, purpleTowerDamage);
    }

    @Override
    public String toString(){
        return "Purple Tower";
    }
}
