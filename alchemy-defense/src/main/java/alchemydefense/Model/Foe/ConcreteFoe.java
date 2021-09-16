package alchemydefense.Model.Foe;

import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Foe;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author Willem Brahmstaedt
 *
 * Class representing a concrete foe. Implements Foe, BoardObject and Health.
 *
 * Date: 2021-09-14
 *
 */

public class ConcreteFoe implements BoardObject, Foe {
    private final int MAX_HP = 100;
    private int currentHP;
    private Point worldPosition;
    private Point cellPosition;
    private final PathFinder pathFinder;
    private LinkedList<Point> path;

    public ConcreteFoe(int boardHeight, PathFinder pathFinder) {
        int randomHeight = (int) (Math.random() * boardHeight);
        setCellPosition(new Point(0, randomHeight));

        this.pathFinder = pathFinder;
        this.path = pathFinder.calculatePath(null, getCellPosition());
        this.currentHP = MAX_HP;
    }

    /**
     * Calculates damage taken
     * @param damageCount Represents how much damage that shall be taken
     * @return True if the foe survives, false otherwise
     */

    @Override
    public boolean takeDamage(int damageCount) {
        setCurrentHP(getCurrentHP() - damageCount);

        return this.currentHP > 0;
    }

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
    public void update() {
        path = pathFinder.calculatePath(null, getCellPosition());
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
}
