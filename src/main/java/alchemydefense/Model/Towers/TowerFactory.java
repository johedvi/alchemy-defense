package alchemydefense.Model.Towers;


import alchemydefense.Model.Towers.TowerHierarchy.*;
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
    public static ITower createTower(BoardObjectType boardObjectType) throws IllegalArgumentException {

        switch (boardObjectType) {
            case RED_TOWER: return new Tower(BoardObjectType.RED_TOWER, "red-crystal.png",2,20);
            case BLUE_TOWER: return new Tower(BoardObjectType.BLUE_TOWER, "blue-crystal.png", 2,20);
            case GREEN_TOWER: return new Tower(BoardObjectType.GREEN_TOWER,"green-crystal.png",  2,20);
            case PURPLE_TOWER: return new Tower(BoardObjectType.PURPLE_TOWER,"purple-crystal.png",  3,30);
            default: throw new IllegalArgumentException();
        }

    }
}



