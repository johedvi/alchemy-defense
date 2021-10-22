package alchemydefense.Controller;

<<<<<<< HEAD
import alchemydefense.Model.ITowerHandler;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
=======
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.ITower;
import alchemydefense.Model.Towers.Tower;
>>>>>>> towerRefactor
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;

/**
 * A controller that handles user interaction with the Userinterface.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-26
 */
public class TowerController implements ITowerController {

    private boolean towerPressed = false;

    private final ITowerHandler towerHandler;
    private BoardObjectType activeTower = null;

    private Vector towerCell = null;

    public TowerController(ITowerHandler model) {
        this.towerHandler = model;
    }

    @Override
    public void createTower(Vector cell) {
<<<<<<< HEAD
        this.towerHandler.placeTowerInCell(this.activeTower, cell);
=======

        model.placeTowerInCell(activeTower, cell);

>>>>>>> towerRefactor
    }
    @Override
    public void setRedTowerActive() {
        this.activeTower = BoardObjectType.RED_TOWER;
    }
    @Override
    public void setBlueTowerActive() {
        this.activeTower = BoardObjectType.BLUE_TOWER;
    }
    @Override
    public void setGreenTowerActive() {
        this.activeTower = BoardObjectType.GREEN_TOWER;
    }
    @Override
    public void setPurpleTowerActive() {
        this.activeTower = BoardObjectType.PURPLE_TOWER;
    }
    @Override
    public BoardObjectType getActiveTower() { return this.activeTower; }

    @Override
    public boolean isHoldingTower() {
        return this.activeTower != null;
    }
    @Override
    public void setHoldingTowerFalse() {
        this.activeTower = null;
    }
    @Override
    public void sellTower() { this.towerHandler.sellTower(this.towerCell); }

    @Override
    public void cellPressed(int GRID_WIDTH, int GRID_HEIGHT, int UNIT_IN_PIXELS, int x, int y) {
        int xCor = x / UNIT_IN_PIXELS;
        int yCor = (y / UNIT_IN_PIXELS) - 1;
        Vector cell = new Vector(xCor, yCor);
        if(xCor < GRID_WIDTH && yCor < GRID_HEIGHT) {
            if(this.towerHandler.getBoardObjectInCell(cell) instanceof Tower) {
                this.towerHandler.updateTowerStatListeners(cell);
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

    @Override
    public boolean isTowerPressed() { return this.towerPressed; }
}
