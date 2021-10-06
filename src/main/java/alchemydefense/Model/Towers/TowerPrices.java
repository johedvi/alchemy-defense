package alchemydefense.Model.Towers;

/**
 * Singleton class that stores the values for different towers.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-28
 *
 */

public class TowerPrices {

    private static TowerPrices instance = null;

    private static final int redTowerBuyPrice = 0;
    private static final int blueTowerBuyPrice = 100;
    private static final int greenTowerBuyPrice = 200;
    private static final int purpleTowerBuyPrice = 400;

    private static final int redTowerSellPrice = 10;
    private static final int blueTowerSellPrice = 20;
    private static final int greenTowerSellPrice = 40;
    private static final int purpleTowerSellPrice = 80;


    private TowerPrices() {}

    /**
     * Returns an instance of TowerPrices if it exists, otherwise creates a new one.
     * @return Instance of Towerprices.
     */
    public static TowerPrices getInstance() {
        if(instance == null) {
            instance = new TowerPrices();
        }
        return instance;
    }

    /**
     * Gets the specific buy value of a certain towerType.
     * @param towerType the tower type of which value is requested.
     * @return returns an int of the buy value for a specific tower
     */
    public int getBuyPrice(TowerType towerType) {
        int price = 0;
        switch (towerType) {
            case RED : price = redTowerBuyPrice; break;
            case BLUE: price = blueTowerBuyPrice; break;
            case GREEN: price = greenTowerBuyPrice; break;
            case PURPLE: price = purpleTowerBuyPrice; break;
        }
        return price;
    }

    /**
     * Gets the specific price sell value of a certain towerType.
     * @param towerType the tower type of which value is requested.
     * @return returns an int of the sell value for a specific tower.
     */

    public int getSellPrice(TowerType towerType) {
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
