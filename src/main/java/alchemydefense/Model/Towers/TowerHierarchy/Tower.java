package alchemydefense.Model.Towers.TowerHierarchy;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Towers.TowerType;


/**
 * @author Johan Lindén
 * Date: 2021-09-14
 *
 * A class for an abstract tower. Concrete towers extends this class. Handles
 * all the shared logic of towers. Implements BoardObject.
 *
 *----- Modified ------
 * Date 09-19, By Willem; Removed position attributes and methods associated with them
 *
 * Date 2021-09-27, By Valdemar; Moved responsibility from lower class RedTower to create higher abstraction.
 *
 */

public abstract class Tower implements BoardObject {

    private final TowerType towerType;
    private final String filePath;

    private final int width;
    private final int height;
    private final int range;
    private final int damage;

    private final int sellPrice;

    public Tower(TowerType towerType, String filePath, int width, int height, int range, int damage, int sellPrice) {
        this.towerType = towerType;
        this.filePath = filePath;
        this.width = width;
        this.height = height;
        this.range = range;
        this.damage = damage;
        this.sellPrice = sellPrice;
    }

    public void update() {
        //TODO
    }

    public TowerType getTowerType() { return this.towerType; }

    @Override public String getImageFilePath() { return this.filePath; }

    public int getWidth() { return this.width; }

    public int getHeight() { return this.height; }

    public int getRange() { return this.range; }

    public int getDamage() { return this.damage; }

    public int getSellPrice() { return  this.sellPrice; }

}
