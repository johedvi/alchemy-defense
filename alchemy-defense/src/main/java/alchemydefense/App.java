package alchemydefense;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.GameModel;
import alchemydefense.View.GodView;
import alchemydefense.View.TileView;
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

import java.awt.*;
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

        Pane boardPane;
        private ConcreteFoe TestFoe;

        GodView view;

        GameModel model =  new GameModel();


    @Override
        public void start(Stage stage) throws IOException {
                Group root = new Group();
                Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
                setupAppWindow(stage, scene);



                view = new GodView(root, new TowerController(model));
                model.addBoardListener(view);

                stage.show();
                gameUpdate();

        }


        private void setupAppWindow(Stage stage, Scene scene) {
                Image appIcon = new Image("/app-icon.png");
                stage.getIcons().add(appIcon);
                stage.setTitle("Alchemy Defense");
                stage.setScene(scene);
        }


<<<<<<< Updated upstream
=======
                Button button2 = new Button("Play Button");
                button2.setMaxSize(100, 200);
                button2.setLayoutX(SCENE_WIDTH / 2 + 50);
                button2.setLayoutY(UNIT_IN_PIXELS - UNIT_IN_PIXELS/2);
                button2.setOnAction(actionEvent ->  {
                                gameUpdate();
                         {
                        }
                });

                userInterfacePane.getChildren().add(button2);

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

        boolean createdFoe = false;

        private void createFoe() {

                if (!createdFoe) {
                        TileView tile = (TileView) boardPane.getChildren().get(TestFoe.getCellPosition().x+TestFoe.getCellPosition().y);
                        tile.setImage("foe.png");
                        createdFoe = true;
                }

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

                String image = "tmp-background.png";
                boardPane.setStyle("-fx-background-image: url('" + image + "'); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;");
                return boardPane;
        }
>>>>>>> Stashed changes

        private void gameUpdate() {
                timer = new AnimationTimer() {
                    //TODO: call on model to update
                    private long lastUpdate = 0 ;
                    @Override
                    public void handle(long now) {
                        if (now - lastUpdate >= 100_000_0000) {
                            view.updateTileFoe();
                            lastUpdate = now ;
                        }
                        model.modelUpdate();
                    }

                };
                timer.start();
        }


        public static void main(String[] args) {
                launch();
        }

}
