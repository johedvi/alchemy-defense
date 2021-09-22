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
 * --- Modified ---
 * Added attribute int ID.
 * Valdemar Stenhammar
 * Date: 2021-09-17
 *
 * --- Modified ---
 * Changed method takeDamage to void and added method boolean isAlive instead.
 * Valdemar Stenhammar
 * Date: 2021-09-20
 */

public class ConcreteFoe implements BoardObject, Foe {
    private final int MAX_HP = 100;
    private int currentHP;
    private Point worldPosition;
    private Point cellPosition;
    private final PathFinder pathFinder;
    private LinkedList<Point> path;
    private final int ID;

    public ConcreteFoe(int boardHeight, PathFinder pathFinder, int id){
       // int randomHeight = (int) (Math.random() * boardHeight);
        int randomHeight = (int)(Math.random() * 5);
        setCellPosition(new Point(0, randomHeight));

        this.pathFinder = pathFinder;
        this.path = pathFinder.calculatePath(null, getCellPosition());
        this.currentHP = MAX_HP;
        this.ID = id;

    }

    /**
     * Calculates damage taken
     * @param damageCount Represents how much damage that shall be taken.
     */

    @Override
    public void takeDamage(int damageCount) {
        setCurrentHP(getCurrentHP() - damageCount);
    }

    @Override
    public boolean isAlive() { return this.currentHP > 0; }

    @Override
    public Point getWorldPosition() {
        return worldPosition;
    }

    @Override
    public Point getCellPosition() {
        return cellPosition;
    }

    @Override
    public void setCellPosition(Point cell) {
        this.cellPosition = cell;
    }

    @Override
    public void setWorldPosition(Point cell) {
        //TODO
    }

    @Override
    public void update() {
        path = pathFinder.calculatePath(null, getCellPosition());
    }

    @Override
    public String getImageFilePath() {
        return null;
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
    public void move() {
        setCellPosition(path.removeFirst());
    }

    public int getID() { return this.ID; }
}
