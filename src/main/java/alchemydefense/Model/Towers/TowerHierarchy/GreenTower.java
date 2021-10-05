package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Towers.TowerType;

/**
 * @author Valdemar Stenhammar
 *
 * Class representing a concrete Redtower. Extends Tower.
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

    public GreenTower() {
        super(TowerType.GREEN, imageFilePath, greenTowerWidth, greenTowerHeight, greenTowerRange, greenTowerDamage, sellPrice);
    }

    @Override
    public String toString(){
        return "Green Tower";
    }
}
