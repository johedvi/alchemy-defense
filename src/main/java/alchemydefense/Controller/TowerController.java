package alchemydefense.Controller;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.Tower;

import java.awt.*;

public class TowerController {
    private final GameModel model;
    private Tower.TowerType activeTower = null;

    private BoardObject pressedTower = null;

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
        BoardObject boardObject = model.getBoardObjectInCell(new Point(x, y));
        if(boardObject instanceof Tower) {
            pressedTower = boardObject;
            System.out.println("Tower pressed");
        }
        else {
            pressedTower = null;
        }
    }

    public boolean isTowerPressed() { return this.pressedTower != null; }
}
