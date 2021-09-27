package alchemydefense.Model.Towers;

public class GreenTower extends Tower {

    private static final String imageFilePath = "blue-crystal.png";
    private static final int greenTowerHeight = 100;
    private static final int greenTowerWidth = 100;
    private static final int greenTowerRange = 3;
    private static final int greenTowerDamage = 10;

    public GreenTower() {
        super(Tower.TowerType.GREEN, imageFilePath, greenTowerWidth, greenTowerHeight, greenTowerRange, greenTowerDamage);
    }

    @Override
    public String toString(){
        return "Green Tower";
    }
}
