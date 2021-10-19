package alchemydefense.Controller;

import alchemydefense.View.SelectedTowerView;

/**
 * A controller that handles the displaying of SelectedTowerView.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-10-19
 */
public class ViewController {

    private final TowerController towerController;
    private final SelectedTowerView selectedTowerView;

    public ViewController(TowerController towerController, SelectedTowerView selectedTowerView) {
        this.towerController = towerController;
        this.selectedTowerView = selectedTowerView;
    }

    public void cellPressed() {
        this.selectedTowerView.setVis(towerController.isTowerPressed());
    }

}
