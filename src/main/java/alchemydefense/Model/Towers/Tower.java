package alchemydefense.Model.Towers;
import alchemydefense.Utility.BoardObjectType;


/**
 * A class for a tower. Handles all the shared logic of towers. Implements ITower.
 *
 * @author Johan Lindén
 *
 * Date: 2021-09-14
 */
public class Tower implements ITower {

    private final BoardObjectType boardObjectType;
    private final String filePath;
    private final int range;
    private final int damage;



    /**
     * Another constructor for class Tower
     * @param boardObjectType specific towerType of enum TowerType.
     * @param filePath Location for the image that resembles the Tower.
     * @param range range value for the specific tower.
     * @param damage damage value for the specific tower.

     */
    public Tower(BoardObjectType boardObjectType, String filePath, int range, int damage) {
        this.boardObjectType = boardObjectType;
        this.filePath = filePath;
        this.range = range;
        this.damage = damage;

    }

    @Override public BoardObjectType getBoardObjectType() { return this.boardObjectType; }

    @Override public String getImageFilePath() { return this.filePath; }

    @Override public int getRange() { return this.range; }

    @Override public int getDamage() { return this.damage; }




}
