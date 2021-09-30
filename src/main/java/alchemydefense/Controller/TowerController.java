package alchemydefense.Controller;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public class TowerController {

    private boolean pressedTower = false;

    private final GameModel model;
    private Tower.TowerType activeTower = null;

    public TowerController(GameModel model) {
        this.model = model;
    }

    public void createTower(int row, int col) {
        model.placeTowerInCell(activeTower, new Point(row,col));
    }

    public void setRedTowerActive() {
        this.activeTower = Tower.TowerType.RED;
    }

    public void setBlueTowerActive() {
        this.activeTower = Tower.TowerType.BLUE;
    }
    public void setGreenTowerActive() {
        this.activeTower = Tower.TowerType.GREEN;
    }
    public void setPurpleTowerActive() {
        this.activeTower = Tower.TowerType.PURPLE;
    }

    public boolean isHoldingTower() {
        return activeTower != null;
    }
    public void setHoldingTowerFalse() {
        activeTower = null;
    }

    public Tower.TowerType getActiveTower() { return this.activeTower; }

    public void sellTower() {
        model.sellTower(new Point(11, 4), Tower.TowerType.RED);
    }

    public void cellPressed(int x, int y) {
        if(model.getBoardObjectInCell(new Point(x, y)) instanceof Tower) {
            pressedTower = true;
            System.out.println("Tower pressed");
        }
        else {
            pressedTower = false;
        }
    }

    public boolean isTowerPressed() { return this.pressedTower; }
}
