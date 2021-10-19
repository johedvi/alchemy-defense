package alchemydefense.Controller;

import alchemydefense.View.SelectedTowerView;

public class ViewController {

    private final SelectedTowerView selectedTowerView;

    public ViewController(SelectedTowerView selectedTowerView) {
        this.selectedTowerView = selectedTowerView;
    }

    public void displaySelectedTowerView() {
        selectedTowerView.setVis(true);
    }

    public void hideSelectedTowerView() { selectedTowerView.setVis(false); }

}
