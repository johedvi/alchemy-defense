package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;


/**
 * @author Valdemar Stenhammar
 *
 * Class representing the logic behind buying and selling a specific tower.
 *
 * Date: 2021-10-2
 */

public class TowerTransaction {

    private static final Player player = Player.getPlayer();
    private static final TowerPrices towerPrices = TowerPrices.getInstance();

    public TowerTransaction() {

    }

    /**
     * Buys the specific tower type and decreases players gold.
     * @param towerType the type of tower that should be bought.
     * @return specific towerType created from TowerFactory.
     * @throws Exception "Not enough gold"
     * */

    public Tower buyTower(TowerType towerType) throws Exception {
        int price = towerPrices.getBuyPrice(towerType);
        if(player.canAfford(price)) {
            player.pay(price);
            return TowerFactory.createTower(towerType);
        }
        throw new Exception("Not enough gold.");
    }

    /**
     * Sells specific towerType and increases players gold.
     * @param towerType the type of tower that should be sold.
     * */

    public void sellTower(TowerType towerType) {
        player.increaseGold(towerPrices.getSellPrice(towerType));
    }

}
