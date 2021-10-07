package alchemydefense;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.GameModel;
import alchemydefense.View.BoardView;
import alchemydefense.View.InformationView;
import alchemydefense.View.SelectedTowerView;
import alchemydefense.View.UserInterfaceView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;


/**
 * JavaFX launcher class. Acts as the entry point for the application.
 * WIP
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class App extends Application {
        private static final int SCENE_WIDTH = 832;
        private static final int SCENE_HEIGHT = 512;
        private static final int UNIT_IN_PIXELS = 64;

    private final GameModel model =  new GameModel();


    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        setupAppWindow(stage, scene);

        InformationView informationView = new InformationView(SCENE_WIDTH);
        TowerController towerController = new TowerController(model);

        UserInterfaceView userInterfaceView = new UserInterfaceView(SCENE_WIDTH, SCENE_HEIGHT, UNIT_IN_PIXELS,
                informationView, towerController, new SelectedTowerView(towerController));

        BoardView view = new BoardView(root, towerController, userInterfaceView);
        model.addBoardListener(view);
        model.addPlayerEventListener(informationView);

        stage.setScene(scene);
        //stage.minWidthProperty().bind(scene.heightProperty().multiply(2));
        //stage.minHeightProperty().bind(scene.widthProperty().divide(2));
        stage.show();
        gameUpdate();
        letterbox(scene, view);
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

    private void letterbox(final Scene scene, final BoardView contentPane) {
        final double initWidth  = scene.getWidth();
        final double initHeight = scene.getHeight();
        final double ratio      = initWidth / initHeight;

        SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio, initHeight, initWidth, contentPane);
        scene.widthProperty().addListener(sizeListener);
        scene.heightProperty().addListener(sizeListener);
    }

    private static class SceneSizeChangeListener implements ChangeListener<Number> {
        private final Scene scene;
        private final double ratio;
        private final double initHeight;
        private final double initWidth;
        private final BoardView contentPane;

        public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth, BoardView contentPane) {
            this.scene = scene;
            this.ratio = ratio;
            this.initHeight = initHeight;
            this.initWidth = initWidth;
            this.contentPane = contentPane;
        }

        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
            final double newWidth  = scene.getWidth();
            final double newHeight = scene.getHeight();

            double scaleFactor =
                    newWidth / newHeight > ratio
                            ? newHeight / initHeight
                            : newWidth / initWidth;

            if (scaleFactor >= 1) {
                Scale scale = new Scale(scaleFactor, scaleFactor);
                scale.setPivotX(0);
                scale.setPivotY(0);
                scene.getRoot().getTransforms().setAll(scale);

                contentPane.setSize(newWidth  / scaleFactor, newHeight / scaleFactor);
            } else {
                contentPane.setSize(Math.max(initWidth,  newWidth), Math.max(initHeight, newHeight));
            }
        }
    }
}
