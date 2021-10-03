package alchemydefense.Model.Towers;


import alchemydefense.Model.Towers.TowerHierarchy.Tower;

//TODO Should class really be singleton or should methods getBuyPrice and getSellPrice just be static?
public class TowerPrices {

    private static TowerPrices instance = null;

    private static final int redTowerBuyPrice = 50;
    private static final int blueTowerBuyPrice = 100;
    private static final int greenTowerBuyPrice = 200;
    private static final int purpleTowerBuyPrice = 400;

    private static final int redTowerSellPrice = 10;
    private static final int blueTowerSellPrice = 20;
    private static final int greenTowerSellPrice = 40;
    private static final int purpleTowerSellPrice = 80;

    private TowerPrices() {}

    public static TowerPrices getInstance() {
        if(instance == null) {
            instance = new TowerPrices();
        }
        return instance;
    }

    public int getBuyPrice(Tower.TowerType towerType) {
        int price = 0;
        switch (towerType) {
            case RED : price = redTowerBuyPrice; break;
            case BLUE: price = blueTowerBuyPrice; break;
            case GREEN: price = greenTowerBuyPrice; break;
            case PURPLE: price = purpleTowerBuyPrice; break;
        }
        return price;
    }

    public int getSellPrice(Tower.TowerType towerType) {
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
