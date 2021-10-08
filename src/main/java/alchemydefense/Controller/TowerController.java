package alchemydefense.Controller;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

/**
 * A controller that handles user interaction with the Userinterface.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-26
 */
public class TowerController {

    private boolean towerPressed = false;

    private final GameModel model;
    private BoardObjectType activeTower = null;

    private Vector towerCell = null;

    public TowerController(GameModel model) {
        this.model = model;
    }

    public void createTower(int row, int col) {
        model.placeTowerInCell(activeTower, new Vector(row,col));
    }

    public void setRedTowerActive() {
        this.activeTower = BoardObjectType.RED_TOWER;
    }
    public void setBlueTowerActive() {
        this.activeTower = BoardObjectType.BLUE_TOWER;
    }
    public void setGreenTowerActive() {
        this.activeTower = BoardObjectType.GREEN_TOWER;
    }
    public void setPurpleTowerActive() {
        this.activeTower = BoardObjectType.PURPLE_TOWER;
    }
    public BoardObjectType getActiveTower() { return this.activeTower; }

    public boolean isHoldingTower() {
        return activeTower != null;
    }
    public void setHoldingTowerFalse() {
        activeTower = null;
    }

    public void sellTower() { model.sellTower(this.towerCell); }

    public void cellPressed(Vector cell) {
        if(model.getBoardObjectInCell(cell) instanceof Tower) {
            towerCell = cell;
            towerPressed = true;
        }
        else {
            towerPressed = false;
        }
    }

    public boolean isTowerPressed() { return this.towerPressed; }
}
