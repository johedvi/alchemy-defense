package alchemydefense.View;

import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Wave.WaveListener;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * A view that displays how much gold and hp the current player has.
 * Extends Pane and implements PlayerEventListener.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-21
 */
public class InformationView extends Pane implements PlayerEventListener, WaveListener {

    private final Label goldAmount;
    private final Label healthAmount;
    private final Label waveCounter;
    Image wave = new Image("waveDrop.png");
    ImageView waveDrop = new ImageView(wave);
    Image gold = new Image("goldCoin.png");
    ImageView goldCoin = new ImageView(gold);
    Image health = new Image("heartIcon.png");
    ImageView heartIcon = new ImageView(health);

    public InformationView(int SCENE_WIDTH) {

        this.setPrefSize(150, 65);
        this.setLayoutX(SCENE_WIDTH-175);
        this.setLayoutY(10);
        this.setStyle("-fx-background-color: grey");
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));



        this.goldAmount = new Label();
        this.goldAmount.setLayoutX(10);
        this.goldAmount.setLayoutY(5);
        this.goldAmount.setGraphic(goldCoin);
        this.getChildren().add(goldAmount);

        this.healthAmount = new Label();
        this.healthAmount.setLayoutX(10);
        this.healthAmount.setLayoutY(25);
        this.healthAmount.setGraphic(heartIcon);
        this.getChildren().add(healthAmount);

        this.waveCounter = new Label();
        this.waveCounter.setLayoutX(10);
        this.waveCounter.setLayoutY(45);
        this.waveCounter.setGraphic(waveDrop);
        this.getChildren().add(waveCounter);
    }


    @Override
    public void goldAmountChanged(int newValue) { goldAmount.setText("Gold: " + newValue); }

    @Override
    public void healthAmountChanged(int newValue) { healthAmount.setText("Health: " + newValue); }

    @Override
    public void waveCounterChanged(int newWaveValue) { waveCounter.setText("Wave: " + newWaveValue); }
}
