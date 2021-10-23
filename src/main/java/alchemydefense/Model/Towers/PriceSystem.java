package alchemydefense.Model.Towers;

/**
 * A class for a PriceSystem. Represents all the data for prices of a Boardobject.
 *
 * @author Johan Lindén
 *
 * Date: 2021-09-26
 */


public class PriceSystem {

    private final int buyPrice;
    private final int sellPrice;

    public PriceSystem(int buyPrice, int sellPrice) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }


    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
