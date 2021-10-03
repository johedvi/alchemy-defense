package alchemydefense.Model.Towers;


import alchemydefense.Model.Towers.TowerHierarchy.*;

import java.lang.IllegalArgumentException;

public class TowerFactory {

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



