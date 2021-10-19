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

    public void createTower(Vector cell) {
        this.model.placeTowerInCell(this.activeTower, cell);
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
        return this.activeTower != null;
    }
    public void setHoldingTowerFalse() {
        this.activeTower = null;
    }

    public void sellTower() { this.model.sellTower(this.towerCell); }

    public void cellPressed(int GRID_WIDTH, int GRID_HEIGHT, int UNIT_IN_PIXELS, int x, int y) {
        int xCor = x / UNIT_IN_PIXELS;
        int yCor = (y / UNIT_IN_PIXELS) - 1;
        Vector cell = new Vector(xCor, yCor);
        if(xCor < GRID_WIDTH && yCor < GRID_HEIGHT) {
            if(this.model.getBoardObjectInCell(cell) instanceof Tower) {
                this.model.updateTowerStatListeners(cell);
                this.towerCell = cell;
                this.towerPressed = true;
            }
            else if(isHoldingTower()) {
                createTower(cell);
                this.towerPressed = false;
            }
            else {
                this.towerPressed = false;
            }
        }
    }

    public void startNewWave() { this.model.startNewWave(); }

    public boolean isTowerPressed() { return this.towerPressed; }
}
