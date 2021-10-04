package alchemydefense.View;


import javafx.scene.layout.Pane;

public class BackGroundView extends Pane {


    public BackGroundView(int SCENE_WIDTH, int UNIT_IN_PIXELS) {

        this.setPrefSize(150, 100);
        this.setLayoutX(SCENE_WIDTH - 175);
        this.setLayoutY(15);
        this.setStyle("-fx-background-color: white");


    }

}