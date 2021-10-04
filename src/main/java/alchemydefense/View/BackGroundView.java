package alchemydefense.View;


import javafx.scene.layout.Pane;

public class BackGroundView extends Pane {
    public BackGroundView(int scene_width, int scene_height, int unit_in_pixel, InformationView informationView) {
        this.setPrefSize(scene_width, unit_in_pixel * 2);
        this.setLayoutX(0);
        this.setLayoutY(scene_height - 2 * unit_in_pixel);
        this.setStyle("-fx-background-color: blue");



    }
}
