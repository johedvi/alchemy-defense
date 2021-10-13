package alchemydefense.View;

import alchemydefense.Controller.TowerController;
import javafx.scene.layout.Pane;

/**
 * A view that displays the Userinterface.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-26
 */
public class UserInterfaceView extends Pane {

    private final SelectedTowerView selectedTowerView;

    public UserInterfaceView(int scene_width, int scene_height, int unit_in_pixel, InformationView informationView,
                             TowerController towerController, SelectedTowerView selectedTowerView) {

        this.selectedTowerView = selectedTowerView;

        this.setPrefSize(scene_width, scene_height);
        this.setLayoutX(0);
        this.setLayoutY(6 * unit_in_pixel);
        this.setStyle("-fx-background-color: blue");

        javafx.scene.control.Button redTowerButton = new javafx.scene.control.Button("Red Tower");
        redTowerButton.setMaxSize(100, 200);
        redTowerButton.setLayoutX(scene_width / 2 - 50);
        redTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        redTowerButton.setOnMouseClicked(e -> {
            towerController.setRedTowerActive();
        });
        this.getChildren().add(redTowerButton);

        javafx.scene.control.Button blueTowerButton = new javafx.scene.control.Button("Blue Tower");
        blueTowerButton.setMaxSize(100, 200);
        blueTowerButton.setLayoutX(scene_width / 2 - 150);
        blueTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        blueTowerButton.setOnMouseClicked(e -> {
            towerController.setBlueTowerActive();
        });
        this.getChildren().add(blueTowerButton);

        javafx.scene.control.Button purpleTowerButton = new javafx.scene.control.Button("Purple Tower");
        purpleTowerButton.setMaxSize(100, 200);
        purpleTowerButton.setLayoutX(scene_width / 2 - 50);
        purpleTowerButton.setLayoutY(unit_in_pixel - unit_in_pixel / 4);
        purpleTowerButton.setOnMouseClicked(e -> {
            towerController.setPurpleTowerActive();
        });
        this.getChildren().add(purpleTowerButton);

        javafx.scene.control.Button greenTowerButton = new javafx.scene.control.Button("Green Tower");
        greenTowerButton.setMaxSize(100, 200);
        greenTowerButton.setLayoutX(scene_width / 2 - 150);
        greenTowerButton.setLayoutY(unit_in_pixel - unit_in_pixel / 4);
        greenTowerButton.setOnMouseClicked(e -> {
            towerController.setGreenTowerActive();
        });
        this.getChildren().add(greenTowerButton);

        javafx.scene.control.Button newWaveButton = new javafx.scene.control.Button("Start new wave");
        newWaveButton.setMaxSize(100, 200);
        newWaveButton.setLayoutX(scene_width / 2 + 100);
        newWaveButton.setLayoutY(unit_in_pixel - unit_in_pixel / 4);
        newWaveButton.setOnMouseClicked(e -> {
            towerController.startNewWave();
        });
        this.getChildren().add(newWaveButton);

        this.getChildren().add(informationView);
        this.getChildren().add(selectedTowerView);
    }

    public SelectedTowerView getSelectedTowerView() { return this.selectedTowerView; }
}
