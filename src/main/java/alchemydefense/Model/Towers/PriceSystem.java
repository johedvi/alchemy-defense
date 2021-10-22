package alchemydefense.Model.Towers;

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
