package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Utility.BoardObjectType;

/**
 * Class representing a concrete Redtower. Extends Tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-22
 *
 */
public class BlueTower extends Tower {
    private static final String imageFilePath = "blue-crystal.png";
    private static final int blueTowerRange = 2;
    private static final int blueTowerDamage = 20;

    /**
     * Constructor for BlueTower.
     * @see Tower for call to super.
     */
    public BlueTower() {
        super(BoardObjectType.BLUE_TOWER, imageFilePath, blueTowerRange, blueTowerDamage);
    }

    @Override
    public String toString(){
        return "Blue Tower";
    }
}
