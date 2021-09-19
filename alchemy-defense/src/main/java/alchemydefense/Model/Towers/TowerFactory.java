package alchemydefense.Model.Towers;


import java.awt.*;
import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException;

public class TowerFactory {


    public static Tower createTower(Tower.TowerType towerType) throws IllegalArgumentException, FileNotFoundException {
        if (towerType == Tower.TowerType.RED) {
            return new RedTower();
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}



