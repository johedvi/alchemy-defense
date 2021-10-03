package alchemydefense.Model.Towers;

public class TowerPurchase {

    private static final int redTowerPrice = 50;
    private static final int blueTowerPrice = 100;
    private static final int greenTowerPrice = 200;
    private static final int purpleTowerPrice = 400;

    private final Tower tower;

    public TowerPurchase(Tower.TowerType towerType) {
        this.tower = TowerFactory.createTower(towerType);
    }

    public static int getPrice(Tower.TowerType towerType) {
        int price = 0;
        switch (towerType) {
            case RED : price = redTowerPrice; break;
            case BLUE: price = blueTowerPrice; break;
            case GREEN: price = greenTowerPrice; break;
            case PURPLE: price = purpleTowerPrice; break;
        }
        return price;
    }

    public Tower getTower() { return this.tower; }
}
