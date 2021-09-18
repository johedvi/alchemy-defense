package alchemydefense;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private GridPane grid;
    @FXML
    Button towerButton;
    @FXML
    Pane userInterfacePane;

    boolean isHoldingTower = false;     //temporary



    // https://stackoverflow.com/questions/31095954/how-to-get-gridpane-row-and-column-ids-on-mouse-entered-in-each-cell-of-grid-in
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numCols = 10 ;
        int numRows = 5;

        for (int i = 0 ; i < numCols ; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }
    }

    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseEntered(e -> {
            //System.out.printf("Mouse is at grid cell [%d, %d]%n", colIndex, rowIndex);
        });
        grid.add(pane, colIndex, rowIndex);
    }

    @FXML
    private void mouseClickedTowerButton(MouseEvent e){
        if(isHoldingTower == true){
            isHoldingTower = true;
        }

        Image tower = new Image("app-icon.png");
        ImageView towerImageView = new ImageView(tower);
        towerImageView.setFitHeight(64);
        towerImageView.setFitWidth(64);
        towerImageView.setLayoutX(e.getSceneX() - 32);
        towerImageView.setLayoutY(e.getSceneY() - 32);
        rootPane.getChildren().add(towerImageView);
        System.out.println("DING");

        DragController dragController = new DragController(towerImageView, true);


    }

}
