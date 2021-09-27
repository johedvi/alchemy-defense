package alchemydefense.View;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardListener;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Towers.Tower;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.awt.*;


public class BoardView extends AnchorPane implements BoardListener {
    private static final int SCENE_WIDTH = 768;
    private static final int SCENE_HEIGHT = 448;
    private static final int UNIT_IN_PIXELS = 64;
    private static final int GRID_WIDTH = 12;
    private static final int GRID_HEIGHT = 5;

    private final ImageView towerImage = new ImageView();

    Pane boardPane;

    private final TowerController towerController;


    public BoardView(Group root, TowerController towerController, UserInterfaceView userInterfaceView) {
        this.towerController = towerController;

        towerImage.setFitHeight(UNIT_IN_PIXELS);
        towerImage.setFitWidth(UNIT_IN_PIXELS);
        root.getChildren().add(towerImage);
        towerImage.setVisible(false);


        boardPane = setupBoardPane();

        setupMouseEventHandling(root);

        root.getChildren().add(userInterfaceView);
        root.getChildren().add(boardPane);
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
                int y = (int) mouseEvent.getY() / UNIT_IN_PIXELS;
                if(x < GRID_WIDTH && y < GRID_HEIGHT){
                    if(towerController.isHoldingTower()){
                        System.out.println("TJo");
                        towerController.createTower(x,y);
                    }
                }
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY)
            {
                towerController.setHoldingTowerFalse();
                towerImage.setVisible(false);
            }
        });
    }


    private Pane setupBoardPane() {
        Pane boardPane = new Pane();
        boardPane.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT - 2 * 64);
        for (int i = 0 ; i < GRID_WIDTH ; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
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


    private void updateTileTower(int x, int y, String imageFilePath) {
        TileView tile = (TileView) boardPane.getChildren().get(x * GRID_HEIGHT + y);
        tile.setImage(imageFilePath);

    }

    private void clearTile(int x, int y){
        TileView tile = (TileView) boardPane.getChildren().get(x * GRID_HEIGHT + y);
        tile.ClearImage();
    }

    private void setTowerImage(Tower.TowerType towerType) {
        switch (towerType) {
            case RED: towerImage.setImage(new Image("red-crystal.png")); break;
            case BLUE: towerImage.setImage(new Image("blue-crystal.png")); break;
            case PURPLE: towerImage.setImage(new Image("purple-crystal.png")); break;
            case GREEN: towerImage.setImage(new Image("green-crystal.png")); break;
        }
    }

    @Override
    public void placeObjects(Board board) {
        for (int i = 0; i < board.getBoardHeight(); i++){
            for (int j = 0; j < board.getBoardWidth(); j++) {
                BoardObject object = board.getBoardObject(new Point(j,i));
                if (object != null)
                    updateTileTower(j,i, object.getImageFilePath());
                else
                    clearTile(j,i);
            }
        }
    }
}