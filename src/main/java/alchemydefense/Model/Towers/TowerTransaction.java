package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;

public class TowerTransaction {

    private static final Player player = Player.getPlayer();
    private static final TowerPrices towerPrices = TowerPrices.getInstance();

    public TowerTransaction() {

    }

    public Tower buyTower(Tower.TowerType towerType) throws Exception {
        int price = towerPrices.getBuyPrice(towerType);
        if(player.canAfford(price)) {
            player.pay(price);
            return TowerFactory.createTower(towerType);
        }
        throw new Exception("Not enough gold.");
    }

    public void sellTower(Tower.TowerType towerType) {
        player.increaseGold(towerPrices.getSellPrice(towerType));
    }

}
