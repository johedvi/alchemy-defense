package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;

/**
 * Class representing the logic behind buying and selling a specific tower.
 *
 * @author Valdemar Stenhammar
 * Date: 2021-10-2
 *
 * ----- Modified -----
 * Date: 2021-09-26, By Johan; Removed switch cases for boardobjectType.
 *
 */
public class TowerTransaction {

    /**
     * Private constructor to prevent instantiation of class.
     */
    private TowerTransaction() { }

    /**
     * Buys the specific tower type and decreases players gold.
     * @param tower The specific tower of a certain type.
     * @param player The current player.
     * @return specific towerType created from TowerFactory.
     * @throws Exception "Not enough gold"
     */
    public static ITower buyTower(ITower tower, Player player) throws Exception {

        int price = tower.getBuyPrice();

        if(player.canAfford(price)) {
            player.pay(price);
            return tower;
        }
        throw new Exception("Not enough gold.");
    }

    /**
     * Sells specific towerType and increases players gold.
     * @param tower The specific tower of a certain type.
     * @param player The current player.
     */
    public static void sellTower(ITower tower, Player player) {
        int price = tower.getSellPrice();
        player.increaseGold(price);
    }






}
