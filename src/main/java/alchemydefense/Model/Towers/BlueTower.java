package alchemydefense.Model.Towers;

public class BlueTower extends Tower {

    private static final String imageFilePath = "blue-crystal.png";
    private static final int blueTowerHeight = 100;
    private static final int blueTowerWidth = 100;
    private static final int blueTowerRange = 3;
    private static final int blueTowerDamage = 10;

    private static final int sellPrice = 20;

    public BlueTower() {
        super(Tower.TowerType.BLUE, imageFilePath, blueTowerWidth, blueTowerHeight, blueTowerRange, blueTowerDamage, sellPrice);
    }

    @Override
    public String toString(){
        return "Blue Tower";
    }
}
