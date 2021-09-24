package alchemydefense.Model.Foe;

import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Interfaces.Foe;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * @author Willem Brahmstaedt
 *
 * Class representing a concrete foe. Implements Foe, BoardObject and Health.
 *
 * Date: 2021-09-14
 *
 * ----- Modified -----
 * Date: 09-19, By Willem; Removed @Override for methods originally from BoardObject
 *
 * Added attribute int ID.
 * Valdemar Stenhammar
 * Date: 2021-09-17
 *
 * Changed method takeDamage to void and added method boolean isAlive instead.
 * Valdemar Stenhammar
 * Date: 2021-09-20
 */

public class ConcreteFoe implements BoardObject, Foe {
    private final int MAX_HP = 100;
    private int currentHP;
    private String imageFilePath = "/foe.png";

    public ConcreteFoe(){
        this.currentHP = MAX_HP;
    }

    /**
     * Calculates damage taken
     * @param damageCount Represents how much damage that shall be taken
     * @return True if the foe survives, false otherwise
     */

    @Override
    public void takeDamage(int damageCount) {
        setCurrentHP(getCurrentHP() - damageCount);

    }


    @Override
    public String getImageFilePath() {
        return imageFilePath;

    }

    @Override
    public int getMaxHP() {
        return this.MAX_HP;
    }

    @Override
    public int getCurrentHP() {
        return this.currentHP;
    }

    @Override
    public void setCurrentHP(int hp) {
        this.currentHP = hp;
    }

    @Override
    public boolean isAlive() {
        return getCurrentHP() > 0;
    }

    @Override
    public void move() {
        setCellPosition(path.removeFirst());
    }

    @Override
    public String toString(){
        return "ConcreteEnemy";
    }
}
