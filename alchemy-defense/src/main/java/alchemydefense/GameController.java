package alchemydefense;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    final int gridPixelSizeWidth = 768;
    final int gridPixelSizeHeight = 448 - 64 * 2;
    final int numberOfCellRows = 5;
    final int numberOfCellColumns = 12;

    private ImageView[][] tileBoard = new ImageView[numberOfCellColumns][numberOfCellRows];

    private Group tiles = new Group();
    private Group towers = new Group();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Pane gridPane;

    @FXML
    Button towerButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0 ; i < numberOfCellColumns ; i++) {
            for (int j = 0; j < numberOfCellRows; j++) {
                Rectangle rectangle = new Rectangle(i*64,j*64, 64,64);
                rectangle.setFill(javafx.scene.paint.Color.WHITE);
                rectangle.setStroke(javafx.scene.paint.Color.BLACK);
                gridPane.getChildren().add(rectangle);
            }
        }

    }

    private void addPane(int colIndex, int rowIndex) {
        StackPane pane = new StackPane();
        pane.setOnMouseEntered(e -> {
            System.out.printf("Mouse is at grid cell [%d, %d]%n", colIndex, rowIndex);
        });
        //grid.add(pane, colIndex, rowIndex);
    }




    @FXML
    private void mouseClickedTowerButton(MouseEvent e){

        Image tower = new Image("app-icon.png");
        ImageView towerImageView = new ImageView(tower);
        towerImageView.setFitHeight(64);
        towerImageView.setFitWidth(64);
        towerImageView.setLayoutX(e.getSceneX() - 32);
        towerImageView.setLayoutY(e.getSceneY() - 32);

        rootPane.getChildren().add(towerImageView);


        DragController dragController = new DragController(towerImageView, true);
        towerImageView.setOnMouseReleased(event -> {
            rootPane.getChildren().remove(towerImageView);
            int mouseX = (int)event.getSceneX() / 64;
            int mouseY = (int)event.getSceneY() / 64;
            placeImageInCell(mouseX, mouseY, towerImageView);
        });
    }

    private void placeImageInCell(int x, int y, ImageView imageView){

        System.out.println(x + " " + y);
        tileBoard[x][y] = imageView;
        tileBoard[x][y].setLayoutX(x * 64);
        tileBoard[x][y].setLayoutY(y * 64);
        rootPane.getChildren().add(tileBoard[x][y]);
    }
}
