package alchemydefense;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private GridPane grid;



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
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
        });
        grid.add(pane, colIndex, rowIndex);
    }

}
