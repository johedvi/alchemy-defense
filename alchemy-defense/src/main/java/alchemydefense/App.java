package alchemydefense;

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


    @Override
        public void start(Stage stage) throws IOException {
                Group root = new Group();
                Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
                setupAppWindow(stage, scene);


                GameModel model = new GameModel();
                view = new GodView(root, new TowerController(model));


                stage.show();

        }


        private void setupAppWindow(Stage stage, Scene scene) {
                Image appIcon = new Image("/app-icon.png");
                stage.getIcons().add(appIcon);
                stage.setTitle("Alchemy Defense");
                stage.setScene(scene);
        }



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
                    }
                };
                timer.start();
        }


        public static void main(String[] args) {
                launch();
        }

}
