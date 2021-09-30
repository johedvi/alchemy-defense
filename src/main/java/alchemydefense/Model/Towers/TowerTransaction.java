package alchemydefense.Model.Towers;

import alchemydefense.Model.Player.Player;

public class TowerTransaction {

    Player player = Player.getPlayer();

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
        int price = getBuyPrice(towerType);
        if(player.canAfford(price)) {
            player.pay(price);
            return TowerFactory.createTower(towerType);
        }
        throw new Exception("Not enough gold.");
    }

    public void sellTower(Tower.TowerType towerType) {
        player.increaseGold(getSellPrice(towerType));
    }

    private int getBuyPrice(Tower.TowerType towerType) {
        int price = 0;
        switch (towerType) {
            case RED : price = redTowerBuyPrice; break;
            case BLUE: price = blueTowerBuyPrice; break;
            case GREEN: price = greenTowerBuyPrice; break;
            case PURPLE: price = purpleTowerBuyPrice; break;
        }
        return price;
    }

    private int getSellPrice(Tower.TowerType towerType) {
        int price = 0;
        switch (towerType) {
            case RED : price = redTowerSellPrice; break;
            case BLUE: price = blueTowerSellPrice; break;
            case GREEN: price = greenTowerSellPrice; break;
            case PURPLE: price = purpleTowerSellPrice; break;
        }
        return price;
    }
}
