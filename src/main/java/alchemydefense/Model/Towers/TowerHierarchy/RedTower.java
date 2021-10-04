package alchemydefense.Model.Towers.TowerHierarchy;


import alchemydefense.Model.Towers.TowerType;

/**
 * @author Johan Lindén
 *
 * Class representing a concrete Redtower. Extends Tower.
 *
 * Date: 2021-09-14
 *
 */

public class RedTower extends Tower {

    private static final String imageFilePath = "red-crystal.png";
    private static final int redTowerHeight = 100;
    private static final int redTowerWidth = 100;
    private static final int redTowerRange = 3;
    private static final int redTowerDamage = 10;

    private static final int sellPrice = 10;

    public RedTower() {
        super(TowerType.RED, imageFilePath, redTowerWidth, redTowerHeight, redTowerRange, redTowerDamage, sellPrice);
    }

    @Override
    public String toString(){
            return "Red Tower";
    }

}

