package alchemydefense.Controller;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public class TowerController {
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

    public Tower.TowerType getActiveTower() { return activeTower;  }
}
