package alchemydefense.Model.Interfaces;

import alchemydefense.Model.Towers.Tower;

import java.awt.*;
import java.util.HashMap;

public interface ModelListener {
    void placeTowers(HashMap<Tower, Point> towerHash);

    void placeFoes(HashMap<Foe, Point> foeHash);
}
