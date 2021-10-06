package alchemydefense.View;

import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
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
public class InformationView extends Pane implements PlayerEventListener {

    private final Label goldAmount;
    private final Label healthAmount;

    public InformationView(int SCENE_WIDTH) {

        this.setPrefSize(150, 100);
        this.setLayoutX(SCENE_WIDTH-175);
        this.setLayoutY(15);
        this.setStyle("-fx-background-color: white");

        this.goldAmount = new Label();
        this.goldAmount.setText("Gold: " + Player.getPlayer().getGold());
        this.goldAmount.setLayoutX(10);
        this.goldAmount.setLayoutY(10);
        this.getChildren().add(goldAmount);

        this.healthAmount = new Label();
        this.healthAmount.setText("Health: " + Player.getPlayer().getHp());
        this.healthAmount.setLayoutX(10);
        this.healthAmount.setLayoutY(30);
        this.getChildren().add(healthAmount);

        Player.getPlayer().addPlayerEventListener(this);
    }

    @Override
    public void goldAmountChanged(int newValue) { goldAmount.setText("Gold: " + newValue); }

    @Override
    public void healthAmountChanged(int newValue) { healthAmount.setText("Health: " + newValue);}
}
