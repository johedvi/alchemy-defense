package alchemydefense.Model.Towers;


/**
 * @author Johan Lindén
 *
 * Class representing a concrete tower. Extends Tower.
 *
 * Date: 2021-09-14
 *
 */

public class RedTower extends Tower {

    private static final String imageFilePath = "blue-crystal.png";
    private static final int redTowerHeight = 100;
    private static final int redTowerWidth = 100;
    private static final int redTowerRange = 3;
    private static final int redTowerDamage = 10;

    public RedTower() {
        super(TowerType.RED, imageFilePath, redTowerWidth, redTowerHeight, redTowerRange, redTowerDamage);
    }

    @Override
    public String toString(){
            return "Red Tower";
    }

}

