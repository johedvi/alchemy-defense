package alchemydefense.View;

import alchemydefense.Controller.TowerController;
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

    private final TowerController towerController;
    private final UserInterfaceView userInterfaceView;


    public BoardView(Group root, TowerController towerController, UserInterfaceView userInterfaceView) {
        this.userInterfaceView = userInterfaceView;
        this.towerController = towerController;

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

        borderImage.setImage(new Image("rocks_complete.png"));
        borderImage.setY(10);
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
            if (mouseEvent.getButton() == MouseButton.PRIMARY)
            {
                int x = (int) mouseEvent.getX() / UNIT_IN_PIXELS;
                int y = (int) ((mouseEvent.getY() / (UNIT_IN_PIXELS)) - 1);
                if(x < GRID_WIDTH && y < GRID_HEIGHT){
                    towerController.cellPressed(new Vector(x, y));
                    if(towerController.isHoldingTower()){
                        towerController.createTower(x,y);
                    }
                    else
                        userInterfaceView.getSelectedTowerView().setVis(towerController.isTowerPressed());
                }
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY)
            {
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
            case RED: towerImage.setImage(new Image("red-crystal.png")); break;
            case BLUE: towerImage.setImage(new Image("blue-crystal.png")); break;
            case PURPLE: towerImage.setImage(new Image("purple-crystal.png")); break;
            case GREEN: towerImage.setImage(new Image("green-crystal.png")); break;
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
