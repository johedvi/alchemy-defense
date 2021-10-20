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
    private final AttackDamageSystem attackDamageSystem;
    private final PriceSystem priceSystem;



    /**
     * Another constructor for class Tower
     * @param boardObjectType specific towerType of enum TowerType.
     * @param filePath Location for the image that resembles the Tower..
     * @param priceSystem
     */

    public Tower(BoardObjectType boardObjectType, String filePath, AttackDamageSystem attackDamageSystem, PriceSystem priceSystem) {
        this.boardObjectType = boardObjectType;
        this.filePath = filePath;
        this.attackDamageSystem = attackDamageSystem;
        this.priceSystem = priceSystem;
    }

    @Override public BoardObjectType getBoardObjectType() { return this.boardObjectType; }

    @Override public String getImageFilePath() { return this.filePath; }

    @Override public int getRange() { return this.attackDamageSystem.getRange(); }

    @Override public int getDamage() { return this.attackDamageSystem.getDamage(); }

    @Override public int getBuyPrice() { return this.priceSystem.getBuyPrice(); }

    @Override public int getSellPrice() { return this.priceSystem.getSellPrice(); }




}
