package alchemydefense.Model.Towers.TowerHierarchy;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Utility.TowerType;


/**
 * A class for an abstract tower. Concrete towers extends this class. Handles
 * all the shared logic of towers. Implements BoardObject.
 *
 * @author Johan Lindén
 *
 * Date: 2021-09-14
 */
public abstract class Tower implements BoardObject {

    private final TowerType towerType;
    private final String filePath;

    private final int range;
    private final int damage;

    /**
     * Another constructor for class Tower
     * @param towerType specific towerType of enum TowerType.
     * @param filePath Location for the image that resembles the Tower.
     * @param range range value for the specific tower.
     * @param damage damage value for the specific tower.
     */
    public Tower(TowerType towerType, String filePath, int range, int damage) {
        this.towerType = towerType;
        this.filePath = filePath;
        this.range = range;
        this.damage = damage;
    }

    public TowerType getTowerType() { return this.towerType; }

    @Override public String getImageFilePath() { return this.filePath; }

    public int getRange() { return this.range; }

    public int getDamage() { return this.damage; }
}
