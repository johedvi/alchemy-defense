package alchemydefense.View;

import alchemydefense.Controller.ITowerController;
import alchemydefense.Controller.ViewController;
import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Utility.BoardObjectType;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import alchemydefense.Utility.Vector;

/**
 * A view that displays the Board.
 *
 * @author Felix Jönsson
 *
 * Date: 2021-09-26
 */
public class BoardView extends AnchorPane implements BoardListener {
    private int SCENE_WIDTH = 832;
    private int UNIT_IN_PIXELS = 64;
    private static final int GRID_WIDTH = 12;
    private static final int GRID_HEIGHT = 5;

    private final ImageView towerImage = new ImageView();
    private final ImageView endGoalImage = new ImageView();
    private final ImageView borderImage = new ImageView();

    private final ITowerController towerController;

    private final ViewController viewController;


    public BoardView(Group root, ITowerController towerController, ViewController viewController, UserInterfaceView userInterfaceView) {
        this.towerController = towerController;
        this.viewController = viewController;

        towerImage.setFitHeight(UNIT_IN_PIXELS);
        towerImage.setFitWidth(UNIT_IN_PIXELS);

        root.getChildren().add(towerImage);
        towerImage.setVisible(false);

        setupBoardPane();
        setupMouseEventHandling(root);
        BackGroundView();

        root.getChildren().add(userInterfaceView);
        root.getChildren().add(this);
        root.getChildren().add(borderImage);
        root.getChildren().add(endGoalImage);

        userInterfaceView.toFront();

    }

    private void BackGroundView() {

        endGoalImage.setImage(new Image("endGoal.png"));
        endGoalImage.setX(768);
        endGoalImage.setY(64);

        borderImage.setImage(new Image("topBackground.png"));

        borderImage.setFitHeight(64);
        borderImage.setFitWidth(SCENE_WIDTH);

    }

    private void setupMouseEventHandling(Group root) {
        root.setOnMouseMoved(mouseEvent -> {
            if (towerController.isHoldingTower()){
                setTowerImage(towerController.getActiveTower());
                towerImage.setVisible(true);
                towerImage.toFront();
                towerImage.setLayoutX(mouseEvent.getX() - UNIT_IN_PIXELS / 2);
                towerImage.setLayoutY(mouseEvent.getY() - UNIT_IN_PIXELS / 2);
            }
        });

        root.setOnMouseClicked(mouseEvent ->
        {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                towerController.cellPressed(GRID_WIDTH, GRID_HEIGHT, UNIT_IN_PIXELS, (int) mouseEvent.getX(), (int) mouseEvent.getY());
                viewController.cellPressed();
            }

            else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                towerController.setHoldingTowerFalse();
                towerImage.setVisible(false);
            }
        });
    }

    private void setupBoardPane() {
        this.setPrefSize(SCENE_WIDTH, 6 * UNIT_IN_PIXELS);
        for (int i = 0 ; i < GRID_WIDTH ; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                StackPane tileView = new TileView(i*UNIT_IN_PIXELS,(j + 1) * UNIT_IN_PIXELS, UNIT_IN_PIXELS, UNIT_IN_PIXELS);
                this.getChildren().add(tileView);

            }
        }
    }

    private void updateTileImage(int x, int y, String imageFilePath) {
        TileView tile = (TileView) this.getChildren().get(x * GRID_HEIGHT + y);
        tile.addImage(imageFilePath);

    }

    private void clearTile(int x, int y){

            TileView tile = (TileView) this.getChildren().get(x * GRID_HEIGHT + y);
            tile.clearImage();

    }

    private void setTowerImage(BoardObjectType boardObjectType) {
        switch (boardObjectType) {
            case RED_TOWER: towerImage.setImage(new Image("red-crystal.png")); break;
            case BLUE_TOWER: towerImage.setImage(new Image("blue-crystal.png")); break;
            case PURPLE_TOWER: towerImage.setImage(new Image("purple-crystal.png")); break;
            case GREEN_TOWER: towerImage.setImage(new Image("green-crystal.png")); break;
        }
    }

    @Override
    public void renderObjects(Board board) {
        for (int i = 0; i < board.getBoardHeight(); i++){
            for (int j = 0; j < board.getBoardWidth(); j++) {
                BoardObject object = board.getBoardObject(new Vector(j,i));
                if (object != null)
                    updateTileImage(j,i, object.getImageFilePath());
                else
                    clearTile(j,i);
            }
        }
    }

    public void setSize(double width) {
        SCENE_WIDTH = (int) width;
        UNIT_IN_PIXELS = SCENE_WIDTH / 13;

        this.setPrefSize(width, 6 * UNIT_IN_PIXELS);
    }
}
