package alchemydefense.View;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SelectedTowerView extends Pane {

    private final Label sellPriceLabel;

    public SelectedTowerView(int scene_width, int unit_in_pixel) {
        this.setPrefSize(150, 100);
        this.setLayoutX(25);
        this.setLayoutY(15);
        this.setStyle("-fx-background-color: white");

        this.sellPriceLabel = new Label();
        this.sellPriceLabel.setText("Sell for: ");
        this.sellPriceLabel.setLayoutX(10);
        this.sellPriceLabel.setLayoutY(10);
        this.getChildren().add(sellPriceLabel);

        javafx.scene.control.Button sellTowerButton = new javafx.scene.control.Button("Sell Tower");
        sellTowerButton.setMaxSize(100, 200);
        sellTowerButton.setLayoutX(25);
        sellTowerButton.setLayoutY(50);
        sellTowerButton.setOnMouseClicked(e -> {

        });
        this.getChildren().add(sellTowerButton);
    }



}
