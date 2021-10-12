package alchemydefense.View;

import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Wave.WaveListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

    public InformationView(int SCENE_WIDTH) {

        this.setPrefSize(150, 65);
        this.setLayoutX(SCENE_WIDTH-175);
        this.setLayoutY(15);
        this.setStyle("-fx-background-color: white");

        this.goldAmount = new Label();
        this.goldAmount.setLayoutX(10);
        this.goldAmount.setLayoutY(5);
        this.getChildren().add(goldAmount);

        this.healthAmount = new Label();
        this.healthAmount.setLayoutX(10);
        this.healthAmount.setLayoutY(25);
        this.getChildren().add(healthAmount);

        this.waveCounter = new Label();
        this.waveCounter.setLayoutX(10);
        this.waveCounter.setLayoutY(45);
        this.getChildren().add(waveCounter);
    }

    @Override
    public void goldAmountChanged(int newValue) { goldAmount.setText("Gold: " + newValue); }

    @Override
    public void healthAmountChanged(int newValue) { healthAmount.setText("Health: " + newValue); }

    @Override
    public void waveCounterChanged(int newWaveValue) { waveCounter.setText("Wave: " + newWaveValue); }
}
