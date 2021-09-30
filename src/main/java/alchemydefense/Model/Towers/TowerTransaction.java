package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;

public class TowerTransaction {

    private static final Player player = Player.getPlayer();
    private static final TowerPrices towerPrices = TowerPrices.getInstance();

    private static final int redTowerBuyPrice = 50;
    private static final int blueTowerBuyPrice = 100;
    private static final int greenTowerBuyPrice = 200;
    private static final int purpleTowerBuyPrice = 400;

    private static final int redTowerSellPrice = 10;
    private static final int blueTowerSellPrice = 20;
    private static final int greenTowerSellPrice = 40;
    private static final int purpleTowerSellPrice = 80;

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
