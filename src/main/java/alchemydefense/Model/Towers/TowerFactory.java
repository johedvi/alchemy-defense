package alchemydefense.Model.Towers;


import alchemydefense.Model.Towers.TowerHierarchy.*;

import java.lang.IllegalArgumentException;

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
     * @param towerType Type of enum TowerType.
     * @return specific concrete Tower of that type.
     * @throws IllegalArgumentException
     * */

    public static Tower createTower(TowerType towerType) throws IllegalArgumentException {

        //TODO Add more tower types
        switch (towerType) {
            case RED: return new RedTower();
            case BLUE: return new BlueTower();
            case GREEN: return new GreenTower();
            case PURPLE: return new PurpleTower();
            default: throw new IllegalArgumentException();
        }

    }
}



