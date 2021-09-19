package alchemydefense;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class TileView extends Rectangle {
    final int tileSize = 64;
    final String imageFilePath = "app-icon.png";

    public TileView(int x, int y){
        super(x,y);
        setWidth(tileSize);
        setHeight(tileSize);
        Image img = new Image(imageFilePath);
        this.setFill(new ImagePattern(img));
    }
}
