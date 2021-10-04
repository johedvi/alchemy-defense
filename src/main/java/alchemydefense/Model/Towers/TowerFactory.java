package alchemydefense.Model.Towers;


import alchemydefense.Model.Towers.TowerHierarchy.*;

import java.lang.IllegalArgumentException;

/**
 * @author Johan LInden
 *
 * Factory class that creates Tower objects without exposing the creation logic to the client.
 *
 * Date: 2021-9-20
 */



public class TowerFactory {

    /**
     * Creates specific Tower
     * @param towerType
     * @return specific concrete Tower.
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



