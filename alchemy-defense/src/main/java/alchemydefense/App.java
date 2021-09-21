package alchemydefense;

import alchemydefense.Model.Player.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
        private static Scene scene;
        private static final int SCENE_WIDTH = 768;
        private static final int SCENE_HEIGHT = 448;
        private static final int UNIT_IN_PIXELS = 64;

        private AnimationTimer timer;

        //TODO: Better solution
        private ImageView testTower;
        private boolean isHoldingTower = false;

        @Override
        public void start(Stage stage) throws IOException {
                Group root = new Group();
                Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
                setupAppWindow(stage, scene);

                //TEMPORARY CODE
                testTower = new ImageView(new Image("/blue-crystal.png"));
                testTower.setFitHeight(UNIT_IN_PIXELS);
                testTower.setFitWidth(UNIT_IN_PIXELS);
                root.getChildren().add(testTower);
                testTower.setVisible(false);

                Pane boardPane = setupBoardPane();
                Pane userInterfacePane = setupUserInterfacePane();
                setupMouseEventHandling(root);

                root.getChildren().add(userInterfacePane);
                root.getChildren().add(boardPane);

                stage.show();

                gameUpdate();
        }

        private void setupAppWindow(Stage stage, Scene scene) {
                Image appIcon = new Image("/app-icon.png");
                stage.getIcons().add(appIcon);
                stage.setTitle("Alchemy Defense");
                stage.setScene(scene);
        }

        private void setupMouseEventHandling(Group root) {
                root.setOnMouseMoved(mouseEvent -> {
                        if (isHoldingTower){
                                testTower.setVisible(true);
                                testTower.toFront();
                                testTower.setLayoutX(mouseEvent.getX() - UNIT_IN_PIXELS/2);
                                testTower.setLayoutY(mouseEvent.getY() - UNIT_IN_PIXELS/2);
                        }
                });

                root.setOnMouseClicked(mouseEvent ->
                {
                        if (mouseEvent.getButton() == MouseButton.PRIMARY)
                        {
                                int x = (int) mouseEvent.getX() / UNIT_IN_PIXELS;
                                int y = (int) mouseEvent.getY() / UNIT_IN_PIXELS;
                                if(x<12 && y <5){
                                        System.out.println("Mouse clicked on cell: (" + x + ", " + y + ").");
                                        if(isHoldingTower){
                                                System.out.println("Tried to place tower at cell.");
                                        }
                                }
                                else{
                                        System.out.println("Mouse clicked on user interface panel.");
                                }
                        } else if (mouseEvent.getButton() == MouseButton.SECONDARY)
                        {
                                isHoldingTower = false;
                                testTower.setVisible(false);
                        }
                });
        }

        private Pane setupUserInterfacePane() {
                Pane userInterfacePane = new Pane();
                userInterfacePane.setPrefSize(SCENE_WIDTH, UNIT_IN_PIXELS * 2);
                userInterfacePane.setLayoutX(0);
                userInterfacePane.setLayoutY(SCENE_HEIGHT - 2 * UNIT_IN_PIXELS);
                userInterfacePane.setStyle("-fx-background-color: blue");

                Button button = new Button("Tower Button");
                button.setMaxSize(100, 200);
                button.setLayoutX(SCENE_WIDTH / 2 - 50);
                button.setLayoutY(UNIT_IN_PIXELS - UNIT_IN_PIXELS/2);
                button.setOnMouseClicked(e -> {
                        isHoldingTower = true;

                });
                userInterfacePane.getChildren().add(button);

                Button damageButton = new Button("Take damage");
                damageButton.setMaxSize(100, 200);
                damageButton.setLayoutX(SCENE_WIDTH / 2 - 50);
                damageButton.setLayoutY(75);
                damageButton.setOnMouseClicked(e -> {
                        Player.getPlayer().decreaseOneHp();

                });
                userInterfacePane.getChildren().add(damageButton);

                Button payButton = new Button("Pay");
                payButton.setMaxSize(100, 200);
                payButton.setLayoutX(425);
                payButton.setLayoutY(75);
                payButton.setOnMouseClicked(e -> {
                        Player.getPlayer().pay(2);

                });
                userInterfacePane.getChildren().add(payButton);

                userInterfacePane.getChildren().add(new InformationView(SCENE_WIDTH, UNIT_IN_PIXELS));

                return userInterfacePane;
        }

        private Pane setupBoardPane() {
                Pane boardPane = new Pane();
                boardPane.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT - 2 * 64);
                for (int i = 0 ; i < 12 ; i++) {
                        for (int j = 0; j < 5; j++) {
                                Rectangle tileView = new TileView(i*64,j*64, 64,64);
                                tileView.setStroke(javafx.scene.paint.Color.BLACK);
                                tileView.setStrokeWidth(1);
                                boardPane.getChildren().add(tileView);
                        }
                }
                return boardPane;
        }

        private void gameUpdate() {
                timer = new AnimationTimer() {
                        @Override
                        public void handle(long l) {
                                // input
                                // pull model
                                // update view
                        }
                };
                timer.start();
        }

        public static void main(String[] args) {
                launch();
        }

}
