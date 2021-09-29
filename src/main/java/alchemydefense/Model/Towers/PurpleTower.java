package alchemydefense.Model.Towers;

public class PurpleTower extends Tower {

    private static final String imageFilePath = "/purple-crystal.png";
    private static final int purpleTowerHeight = 100;
    private static final int purpleTowerWidth = 100;
    private static final int purpleTowerRange = 3;
    private static final int purpleTowerDamage = 10;

    private static final int buyPrice = 400;
    private static final int sellPrice = 80;

    public PurpleTower() {
        super(TowerType.PURPLE, imageFilePath, purpleTowerWidth, purpleTowerHeight, purpleTowerRange, purpleTowerDamage, buyPrice, sellPrice);
    }

    @Override
    public String toString(){
        return "Purple Tower";
    }
}
