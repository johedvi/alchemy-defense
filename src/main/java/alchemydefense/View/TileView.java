package alchemydefense.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

/**
 * A view that displays Tiles.
 *
 * @author Felix Jönsson
 *
 * Date: 2021-09-26
 */
public class TileView extends StackPane {
    private final HashMap<String, ImageView> images = new HashMap<>();

    public TileView(int startX, int startY, int width, int height) {
        setPrefSize(width, height);
        setLayoutX(startX);
        setLayoutY(startY);

        setDefaultBackground();
    }

    private void setDefaultBackground() {
        String defaultBackground = "available-path.png";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(defaultBackground, 64, 64, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
    }

    public void addImage(String filepath) {
        clearImage();
        if (!images.containsKey(filepath)) {
            ImageView image = new ImageView(new Image(filepath));
            images.put(filepath, image);
        }
        ImageView image = images.get(filepath);
        image.setFitHeight(64);
        image.setFitWidth(64);
        this.getChildren().add(image);
    }

    public void clearImage() {
        getChildren().clear();
    }
}
