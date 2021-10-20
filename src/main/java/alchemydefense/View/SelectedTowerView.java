package alchemydefense.View;

import alchemydefense.Controller.ITowerController;
import alchemydefense.Model.Towers.TowerStatListener;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * A view that displays sell / buy / uppgrade cost when you select a Tower.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-26
 */
public class SelectedTowerView extends Pane implements TowerStatListener {

    private final Label towerTypeLabel;
    private final Label rangeLabel;
    private final Label damageLabel;
    private final Label sellPriceLabel;

    public SelectedTowerView(ITowerController towerController) {
        this.setPrefSize(150, 65);
        this.setLayoutX(445);
        this.setLayoutY(10);
        this.setStyle("-fx-background-color: lightgray");
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        this.towerTypeLabel = new Label();
        this.towerTypeLabel.setLayoutX(10);
        this.towerTypeLabel.setLayoutY(0);
        this.getChildren().add(towerTypeLabel);

        this.rangeLabel = new Label();
        this.rangeLabel.setLayoutX(10);
        this.rangeLabel.setLayoutY(15);
        this.getChildren().add(rangeLabel);

        this.damageLabel = new Label();
        this.damageLabel.setLayoutX(10);
        this.damageLabel.setLayoutY(30);
        this.getChildren().add(damageLabel);

        this.sellPriceLabel = new Label();
        this.sellPriceLabel.setLayoutX(10);
        this.sellPriceLabel.setLayoutY(45);
        this.getChildren().add(sellPriceLabel);

        javafx.scene.control.Button sellTowerButton = new javafx.scene.control.Button("Sell");
        sellTowerButton.setMaxSize(100, 100);
        sellTowerButton.setLayoutX(100);
        sellTowerButton.setLayoutY(30);
        sellTowerButton.setFocusTraversable(false);
        sellTowerButton.setOnMouseClicked(e -> {
            towerController.sellTower();
            this.setVisible(false);
        });
        this.getChildren().add(sellTowerButton);
        this.setVisible(false);
    }

    public void setVis(boolean visible) { this.setVisible(visible);}

    @Override
    public void displayTowerStats(String towerType, int range, int damage, int sellPrice) {
        towerTypeLabel.setText(towerType);
        rangeLabel.setText("Range: " + range);
        damageLabel.setText("Damage: " + damage);
        sellPriceLabel.setText("Sell for: " + sellPrice);
    }
}
