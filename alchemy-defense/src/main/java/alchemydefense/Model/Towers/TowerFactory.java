package alchemydefense.Model.Towers;


import java.awt.*;
import java.io.FileNotFoundException;


public class TowerFactory {


    public static Tower createTower(Tower.TowerType towerType, Point CellPosition) throws FileNotFoundException {
        if (towerType == Tower.TowerType.RED) {
            return new RedTower(CellPosition);
        }
        else {
            return null; //TODO
        }
    }



}



