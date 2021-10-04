package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Towers.TowerType;

public class GreenTower extends Tower {
    private static final String imageFilePath = "green-crystal.png";
    private static final int greenTowerRange = 3;
    private static final int greenTowerDamage = 10;

    public GreenTower() {
        super(TowerType.GREEN, imageFilePath, greenTowerRange, greenTowerDamage);
    }

    @Override
    public String toString(){
        return "Green Tower";
    }
}
