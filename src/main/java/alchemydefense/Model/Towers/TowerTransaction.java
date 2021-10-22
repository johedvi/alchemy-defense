package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;
import alchemydefense.Utility.BoardObjectType;

/**
 * Class representing the logic behind buying and selling a specific tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-10-2
 */
public class TowerTransaction {




    /**
     * Private constructor to prevent instantiation of class.
     */
    private TowerTransaction() { }



    /**
     * Buys the specific tower type and decreases players gold.
<<<<<<< HEAD
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
<<<<<<< HEAD

     */

    public static void sellTower(ITower tower, Player player) {

        int price = tower.getSellPrice();



        player.increaseGold(price);

    }






}
