package alchemydefense.View;

import alchemydefense.Controller.TowerController;
import javafx.scene.layout.Pane;

public class UserInterfaceView extends Pane {
    public UserInterfaceView(int scene_width, int scene_height, int unit_in_pixel, InformationView informationView, TowerController towerController) {
        this.setPrefSize(scene_width, unit_in_pixel * 2);
        this.setLayoutX(0);
        this.setLayoutY(scene_height - 2 * unit_in_pixel);
        this.setStyle("-fx-background-color: blue");

        javafx.scene.control.Button towerButton = new javafx.scene.control.Button("Tower Button");
        towerButton.setMaxSize(100, 200);
        towerButton.setLayoutX(scene_width / 2 - 50);
        towerButton.setLayoutY(unit_in_pixel - unit_in_pixel / 2);
        towerButton.setOnMouseClicked(e -> {
            towerController.setRedTowerActive();
        });
        this.getChildren().add(towerButton);

        this.getChildren().add(informationView);
    }
}
