package alchemydefense.Model.Towers.TowerHierarchy;

import alchemydefense.Model.Towers.TowerType;

public class PurpleTower extends Tower {
    private static final String imageFilePath = "/purple-crystal.png";
    private static final int purpleTowerRange = 3;
    private static final int purpleTowerDamage = 10;

    public PurpleTower() {
        super(TowerType.PURPLE, imageFilePath, purpleTowerRange, purpleTowerDamage);
    }

    @Override
    public String toString(){
        return "Purple Tower";
    }
}
