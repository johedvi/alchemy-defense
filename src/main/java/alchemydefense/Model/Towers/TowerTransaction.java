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

    public TowerTransaction() { }

    /**
     * Buys the specific tower type and decreases players gold.
     * @param boardObjectType the type of tower that should be bought.
     * @return specific towerType created from TowerFactory.
     * @throws Exception "Not enough gold"
     */
    public ITower buyTower(Player player, BoardObjectType boardObjectType) throws Exception {
        int price = TowerPrices.getBuyPrice(boardObjectType);
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
    public void sellTower(Player player, BoardObjectType boardObjectType) {
        player.increaseGold(TowerPrices.getSellPrice(boardObjectType));
    }

}
