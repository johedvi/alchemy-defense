package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.TowerHierarchy.ITower;
import alchemydefense.Utility.BoardObjectType;

/**
 * Class representing the logic behind buying and selling a specific tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-10-2
 */
public class TowerTransaction {

    private static final Player player = Player.getPlayer();

    public TowerTransaction() { }



    /**
     * Buys the specific tower type and decreases players gold.
     * @param boardObjectType the type of tower that should be bought.
     * @return specific towerType created from TowerFactory.
     * @throws Exception "Not enough gold"
     */
    public ITower buyTower(BoardObjectType boardObjectType) throws Exception {

        int price = getTowerBuyPrice(boardObjectType);
        if(player.canAfford(price)) {
            player.pay(price);
            return TowerFactory.createTower(boardObjectType);
        }
        throw new Exception("Not enough gold.");
    }

    /**
     * Sells specific towerType and increases players gold.
     * @param boardObjectType the type of tower that should be sold.
     */
    public void sellTower(BoardObjectType boardObjectType) {
        player.increaseGold(getTowerSellPrice(boardObjectType));
    }


    /**
     * Gets the specific buy value of a certain towerType.
     * @param boardObjectType the tower type of which value is requested.
     * @return returns an int of the buy value for a specific tower
     */

    public static int getTowerBuyPrice(BoardObjectType boardObjectType) {
     int price;
        switch (boardObjectType) {
            case RED_TOWER: price = TowerPrices.redTowerBuyPrice; break;
            case BLUE_TOWER: price = TowerPrices.blueTowerBuyPrice; break;
            case GREEN_TOWER: price = TowerPrices.greenTowerBuyPrice; break;
            case PURPLE_TOWER: price =TowerPrices. purpleTowerBuyPrice; break;
            default:
                throw new IllegalStateException("Unexpected value: " + boardObjectType);
        }
        return price;
    }

    /**
     * Gets the specific price sell value of a certain towerType.
     * @param boardObjectType the tower type of which value is requested.
     * @return returns an int of the sell value for a specific tower.
     */

    public static int getTowerSellPrice(BoardObjectType boardObjectType) {
        int price;
        switch (boardObjectType) {
            case RED_TOWER: price = TowerPrices.redTowerSellPrice; break;
            case BLUE_TOWER: price = TowerPrices.blueTowerSellPrice; break;
            case GREEN_TOWER: price = TowerPrices.greenTowerSellPrice; break;
            case PURPLE_TOWER: price =TowerPrices. purpleTowerSellPrice; break;
            default:
                throw new IllegalStateException("Unexpected value: " + boardObjectType);
        }
        return price;
    }



}
