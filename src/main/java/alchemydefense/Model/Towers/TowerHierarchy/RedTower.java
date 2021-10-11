package alchemydefense.Model.Towers.TowerHierarchy;


import alchemydefense.Utility.BoardObjectType;

/**
 * Class representing a concrete Redtower. Extends Tower.
 *
 * @author Johan Lindén
 *
 * Date: 2021-09-14
 *
 */
public class RedTower extends Tower {
    private static final String imageFilePath = "red-crystal.png";
    private static final int redTowerRange = 2;
    private static final int redTowerDamage = 10;

    /**
     * Constructor for RedTower.
     * @see Tower for call to super.
     */
    public RedTower() {
        super(BoardObjectType.RED_TOWER, imageFilePath, redTowerRange, redTowerDamage);
    }

    @Override
    public String toString(){
            return "Red Tower";
    }

}

