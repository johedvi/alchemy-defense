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

public class GreenTower extends Tower {

    private static final String imageFilePath = "green-crystal.png";
    private static final int greenTowerHeight = 100;
    private static final int greenTowerWidth = 100;
    private static final int greenTowerRange = 3;
    private static final int greenTowerDamage = 10;

    private static final int sellPrice = 40;

    /**
     * Constructor for GreenTower.
     * @see Tower for call to super.
     */

    public GreenTower() {
        super(TowerType.GREEN, imageFilePath, greenTowerWidth, greenTowerHeight, greenTowerRange, greenTowerDamage, sellPrice);
    }

    @Override
    public String toString(){
        return "Green Tower";
    }
}
