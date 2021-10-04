package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Towers.TowerType;

public class BlueTower extends Tower {
    private static final String imageFilePath = "blue-crystal.png";
    private static final int blueTowerRange = 3;
    private static final int blueTowerDamage = 10;

    public BlueTower() {
        super(TowerType.BLUE, imageFilePath, blueTowerRange, blueTowerDamage);
    }

    @Override
    public String toString(){
        return "Blue Tower";
    }
}