package alchemydefense.Model.Towers;

import alchemydefense.Utility.BoardObjectType;

/**
 * Factory class that creates Tower objects without exposing the creation logic to the client.
 *
 * @author Johan LInden
 *
 * Date: 2021-9-20
 */
public class TowerFactory {

    /**
     * Creates a specific Tower of a certain TowerType.
     * @param boardObjectType Type of enum TowerType.
     * @return specific concrete Tower of that type.
     * @throws IllegalArgumentException if towerType doesn't exist.
     */
    public static ITower createTower(BoardObjectType boardObjectType)  {

        switch (boardObjectType) {
            case RED_TOWER: return new Tower(BoardObjectType.RED_TOWER, "red-crystal.png",new AttackDamageSystem(2,20), new PriceSystem(0,10));
            case BLUE_TOWER: return new Tower(BoardObjectType.BLUE_TOWER, "blue-crystal.png", new AttackDamageSystem(2,20), new PriceSystem(100,20));
            case GREEN_TOWER: return new Tower(BoardObjectType.GREEN_TOWER,"green-crystal.png",  new AttackDamageSystem(2,20), new PriceSystem(200,40));
            case PURPLE_TOWER: return new Tower(BoardObjectType.PURPLE_TOWER,"purple-crystal.png",  new AttackDamageSystem(3,30), new PriceSystem(400,80));
            default: throw new IllegalArgumentException("Type does not exist");
        }
    }
}



