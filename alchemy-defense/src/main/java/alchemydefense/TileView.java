package alchemydefense;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class TileView extends Rectangle {
    final int tileSize = 64;
    final String imageFilePath = "available-path.png";

    public TileView(int x, int y, int xx, int yy){
        super(x,y, xx, yy);
        setWidth(tileSize);
        setHeight(tileSize);
        this.setFill(Color.TRANSPARENT);
        //Image img = new Image(imageFilePath);
        //this.setFill(new ImagePattern(img));
    }

    public void setImage(String filePath) {
        Image img = new Image(filePath);
        this.setFill(new ImagePattern(img));
    }

    public String getImageFilePath() {
        return imageFilePath;
    }
}
