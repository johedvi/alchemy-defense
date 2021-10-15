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
            case RED_TOWER: return new RedTower();
            case BLUE_TOWER: return new BlueTower();
            case GREEN_TOWER: return new GreenTower();
            case PURPLE_TOWER: return new PurpleTower();
            default: throw new IllegalArgumentException();
        }

    }
}



