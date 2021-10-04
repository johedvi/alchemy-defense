package alchemydefense;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.GameModel;
import alchemydefense.View.BoardView;
import alchemydefense.View.InformationView;
import alchemydefense.View.SelectedTowerView;
import alchemydefense.View.UserInterfaceView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX launcher class.
 * WIP
 * @Author:
 */
public class App extends Application {
    private static final int SCENE_WIDTH = 768;
    private static final int SCENE_HEIGHT = 448;
    private static final int UNIT_IN_PIXELS = 64;

    private final GameModel model =  new GameModel();


    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        setupAppWindow(stage, scene);

        InformationView informationView = new InformationView(SCENE_WIDTH, UNIT_IN_PIXELS);
        TowerController towerController = new TowerController(model);

        UserInterfaceView userInterfaceView = new UserInterfaceView(SCENE_WIDTH, SCENE_HEIGHT, UNIT_IN_PIXELS,
                informationView, towerController, new SelectedTowerView(towerController));

        BoardView view = new BoardView(root, towerController, userInterfaceView);
        model.addBoardListener(view);
        model.addPlayerEventListener(informationView);

        stage.show();
        gameUpdate();
    }


    private void setupAppWindow(Stage stage, Scene scene) {
        Image appIcon = new Image("/app-icon.png");
        stage.getIcons().add(appIcon);
        stage.setTitle("Alchemy Defense");
        stage.setScene(scene);
    }

    /**
     * Game loop. Handles user input and update of the game model.
     */
    private void gameUpdate() {
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;
            private long lastViewUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_0000) {

                    lastUpdate = now;
                    model.modelUpdate();
                }
                if (now - lastViewUpdate >= 1_000_000) {
                    lastViewUpdate = now;
                    model.updateBoardListeners();
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
                launch();
        }

}
