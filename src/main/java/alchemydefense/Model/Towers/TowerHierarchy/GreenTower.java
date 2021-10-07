package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Utility.TowerType;

/**
 * Class representing a concrete Redtower. Extends Tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-22
 *
 */
public class GreenTower extends Tower {
    private static final String imageFilePath = "green-crystal.png";
    private static final int greenTowerRange = 3;
    private static final int greenTowerDamage = 10;

    /**
     * Constructor for GreenTower.
     * @see Tower for call to super.
     */
    public GreenTower() {
        super(TowerType.GREEN, imageFilePath, greenTowerRange, greenTowerDamage);
    }

    @Override
    public String toString(){
        return "Green Tower";
    }
}
