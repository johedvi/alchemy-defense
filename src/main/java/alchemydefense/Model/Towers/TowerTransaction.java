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

    private static final Player player = Player.getPlayer();

    public TowerTransaction() { }



    /**
     * Buys the specific tower type and decreases players gold.
     * @return specific towerType created from TowerFactory.
     * @throws Exception "Not enough gold"
     */
    public ITower buyTower(ITower tower) throws Exception {

        int price = tower.getBuyPrice();

        if(player.canAfford(price)) {
            player.pay(price);
            return tower;
        }
        throw new Exception("Not enough gold.");
    }

    /**
     * Sells specific towerType and increases players gold.

     */
    public void sellTower(ITower tower) {

        int price = tower.getSellPrice();

        player.increaseGold(price);
    }






}
