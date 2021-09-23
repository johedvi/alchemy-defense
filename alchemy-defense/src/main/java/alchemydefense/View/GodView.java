package alchemydefense.View;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.BoardListener;
import alchemydefense.Model.Interfaces.BoardObject;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.awt.*;

//TODO: Break up into smaller views

public class GodView extends AnchorPane implements BoardListener {
    private static final int SCENE_WIDTH = 768;
    private static final int SCENE_HEIGHT = 448;
    private static final int UNIT_IN_PIXELS = 64;

    private AnimationTimer timer;

    //TODO: Better solution
    private ImageView testTower;
    private boolean isHoldingTower = false;

    Pane boardPane;
    private ConcreteFoe TestFoe;

    private final TowerController towerController;


    public GodView(Group root, TowerController towerController) {
        this.towerController = towerController;

        //TEMPORARY CODE
        testTower = new ImageView(new Image("/blue-crystal.png"));
        testTower.setFitHeight(UNIT_IN_PIXELS);
        testTower.setFitWidth(UNIT_IN_PIXELS);
        root.getChildren().add(testTower);
        testTower.setVisible(false);


        TestFoe = new ConcreteFoe(448, new DumbPathfinder(new Point(11,2)), 1);


        boardPane = setupBoardPane();
        Pane userInterfacePane = setupUserInterfacePane();
        setupMouseEventHandling(root);

        root.getChildren().add(userInterfacePane);
        root.getChildren().add(boardPane);


        createFoe();
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
                        towerController.createTower(x,y);
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

        javafx.scene.control.Button button = new javafx.scene.control.Button("Tower Button");
        button.setMaxSize(100, 200);
        button.setLayoutX(SCENE_WIDTH / 2 - 50);
        button.setLayoutY(UNIT_IN_PIXELS - UNIT_IN_PIXELS/2);
        button.setOnMouseClicked(e -> {
            isHoldingTower = true;
            towerController.setRedTowerActive();
        });
        userInterfacePane.getChildren().add(button);

        javafx.scene.control.Button button2 = new Button("Play Button");
        button2.setMaxSize(100, 200);
        button2.setLayoutX(SCENE_WIDTH / 2 + 50);
        button2.setLayoutY(UNIT_IN_PIXELS - UNIT_IN_PIXELS/2);
        button2.setOnAction(actionEvent ->  {


        });

        userInterfacePane.getChildren().add(button2);

        return userInterfacePane;
    }

    boolean createdFoe = false;

    private void createFoe() {

        if (!createdFoe) {
            TileView tile = (TileView) boardPane.getChildren().get(TestFoe.getCellPosition().x+TestFoe.getCellPosition().y);
            tile.setImage("foe.png");
            createdFoe = true;
            System.out.println(TestFoe.getCellPosition().x);
            System.out.println(TestFoe.getCellPosition().y);
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


    private void updateTileTower(int x, int y, String imageFilePath) {
        TileView tile = (TileView) boardPane.getChildren().get(x * 5 + y);
        tile.setImage(imageFilePath);

    }

    public void updateTileFoe()  {

        TileView tile2 = (TileView) boardPane.getChildren().get(TestFoe.getCellPosition().x*5 + TestFoe.getCellPosition().y);
        tile2.ClearImage();

        TestFoe.update(); // Prob unnecessary
        TestFoe.move();

        TileView tile = (TileView) boardPane.getChildren().get(TestFoe.getCellPosition().x*5 + TestFoe.getCellPosition().y);
        tile.setImage("foe.png");


    }

    @Override
    public void placeObjects(Board board) {
        for (int i = 0; i < board.getBoardHeight(); i++){
            for (int j = 0; j < board.getBoardWidth(); j++) {
                BoardObject object = board.getBoardObject(new Point(i,j));
                if (object != null)
                    updateTileTower(i, j, object.getImageFilePath());
            }
        }
    }
}
