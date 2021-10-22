package alchemydefense.View;

import alchemydefense.Controller.ITowerController;
import alchemydefense.Controller.IWaveController;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * A view that displays the Userinterface.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-26
 */
public class UserInterfaceView extends Pane {

    Image red = new Image("red-crystal.png");
    ImageView redCrystal = new ImageView(red);
    Image green = new Image("green-crystal.png");
    ImageView greenCrystal = new ImageView(green);
    Image blue = new Image("blue-crystal.png");
    ImageView blueCrystal = new ImageView(blue);
    Image purple = new Image("purple-crystal.png");
    ImageView purpleCrystal = new ImageView(purple);
    Image play = new Image("playButton.png");
    ImageView PlayButton = new ImageView(play);

    public UserInterfaceView(int scene_width, int scene_height, int unit_in_pixel, InformationView informationView,
                             ITowerController towerController, IWaveController waveController, SelectedTowerView selectedTowerView) {

        this.setPrefSize(scene_width, scene_height);
        this.setLayoutX(0);
        this.setLayoutY(6 * unit_in_pixel);
        setDefaultBackground();

        javafx.scene.control.Button redTowerButton = new javafx.scene.control.Button("Red Tower");
        redTowerButton.setMaxSize(100, 200);
        redTowerButton.setPrefHeight(50);
        redTowerButton.setPrefWidth(90);
        redTowerButton.setLayoutX(scene_width / 2 - 400);
        redTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        redTowerButton.setContentDisplay(ContentDisplay.TOP);
        redTowerButton.setFocusTraversable(false);
        redTowerButton.setOnMouseClicked(e -> {
            towerController.setRedTowerActive();
        });
        redTowerButton.setGraphic(redCrystal);
        this.getChildren().add(redTowerButton);

        javafx.scene.control.Button blueTowerButton = new javafx.scene.control.Button("Blue Tower");
        blueTowerButton.setMaxSize(100, 200);
        blueTowerButton.setPrefHeight(50);
        blueTowerButton.setPrefWidth(90);
        blueTowerButton.setLayoutX(scene_width / 2 - 290);
        blueTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        blueTowerButton.setContentDisplay(ContentDisplay.TOP);
        blueTowerButton.setFocusTraversable(false);
        blueTowerButton.setOnMouseClicked(e -> {
            towerController.setBlueTowerActive();
        });
        blueTowerButton.setGraphic(blueCrystal);
        this.getChildren().add(blueTowerButton);

        javafx.scene.control.Button greenTowerButton = new javafx.scene.control.Button("Green Tower");
        greenTowerButton.setMaxSize(100, 200);
        greenTowerButton.setPrefHeight(50);
        greenTowerButton.setPrefWidth(90);
        greenTowerButton.setLayoutX(scene_width / 2 - 180);
        greenTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        greenTowerButton.setContentDisplay(ContentDisplay.TOP);
        greenTowerButton.setFocusTraversable(false);
        greenTowerButton.setOnMouseClicked(e -> {
            towerController.setGreenTowerActive();
        });
        greenTowerButton.setGraphic(greenCrystal);
        this.getChildren().add(greenTowerButton);

        javafx.scene.control.Button purpleTowerButton = new javafx.scene.control.Button("Purple Tower");
        purpleTowerButton.setMaxSize(100, 200);
        purpleTowerButton.setPrefHeight(50);
        purpleTowerButton.setPrefWidth(90);
        purpleTowerButton.setLayoutX(scene_width / 2 - 70);
        purpleTowerButton.setLayoutY(unit_in_pixel - 3 * unit_in_pixel / 4);
        purpleTowerButton.setContentDisplay(ContentDisplay.TOP);
        purpleTowerButton.setFocusTraversable(false);
        purpleTowerButton.setOnMouseClicked(e -> {
            towerController.setPurpleTowerActive();
        });
        purpleTowerButton.setGraphic(purpleCrystal);
        this.getChildren().add(purpleTowerButton);

        javafx.scene.control.Button newWaveButton = new javafx.scene.control.Button("Play");
        newWaveButton.setMaxSize(100, 200);
        newWaveButton.setPrefSize(50,50);
        newWaveButton.setLayoutX(scene_width / 2 + 350);
        newWaveButton.setLayoutY(15);
        newWaveButton.setContentDisplay(ContentDisplay.TOP);
        newWaveButton.setGraphic(PlayButton);
        newWaveButton.setFocusTraversable(false);
        newWaveButton.setOnMouseClicked(e -> {
            waveController.startNewWave();
        });
        this.getChildren().add(newWaveButton);

        this.getChildren().add(informationView);
        this.getChildren().add(selectedTowerView);
    }

    private void setDefaultBackground() {
        String defaultBackground = "userinterfaceBackground.png";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(defaultBackground, 84, 84, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
    }
}
