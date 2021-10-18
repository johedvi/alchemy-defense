package alchemydefense.Model.Towers;


import alchemydefense.Utility.BoardObjectType;

/**
 * Class that stores the values for different towers.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-28
 *
 */
public class TowerPrices {

    private static final int redTowerBuyPrice = 0;
    private static final int blueTowerBuyPrice = 100;
    private static final int greenTowerBuyPrice = 200;
    private static final int purpleTowerBuyPrice = 400;

    private static final int redTowerSellPrice = 10;
    private static final int blueTowerSellPrice = 20;
    private static final int greenTowerSellPrice = 40;
    private static final int purpleTowerSellPrice = 80;

    /**
     * Private constructor to prevent instantiation of class.
     */
    private TowerPrices() {}

    /**
     * Gets the specific buy value of a certain towerType.
     * @param boardObjectType the tower type of which value is requested.
     * @return returns an int of the buy value for a specific tower
     */
    public static int getBuyPrice(BoardObjectType boardObjectType) {
        int price = 0;
        switch (boardObjectType) {
            case RED_TOWER: price = redTowerBuyPrice; break;
            case BLUE_TOWER: price = blueTowerBuyPrice; break;
            case GREEN_TOWER: price = greenTowerBuyPrice; break;
            case PURPLE_TOWER: price = purpleTowerBuyPrice; break;
        }
        return price;
    }

    /**
     * Gets the specific price sell value of a certain towerType.
     * @param boardObjectType the tower type of which value is requested.
     * @return returns an int of the sell value for a specific tower.
     */
    public static int getSellPrice(BoardObjectType boardObjectType) {
        int price = 0;
        switch (boardObjectType) {
            case RED_TOWER: price = redTowerSellPrice; break;
            case BLUE_TOWER: price = blueTowerSellPrice; break;
            case GREEN_TOWER: price = greenTowerSellPrice; break;
            case PURPLE_TOWER: price = purpleTowerSellPrice; break;
        }
        return price;
    }
}
