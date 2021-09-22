package alchemydefense.Model.Towers;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * @author Johan Lindén
 *
 * Class representing a concrete tower. Extends Tower.
 *
 * Date: 2021-09-14
 *
 */

public class RedTower extends Tower {

    TowerType Type;

    private static int RedTowerHeight = 100;
    private static int RedTowerWidth = 100;
    private static int RedTowerRange = 100;

        public RedTower(Point cellPosition) throws FileNotFoundException {
        super(cellPosition);
        Type = TowerType.RED;
        this.height = RedTowerHeight;
        this.width = RedTowerWidth;
        this.range = RedTowerRange;
        this.filePath = "images/red-crystal.png";
    }


    @Override
    public void setWorldPosition(Point cell) {
        //TODO
    }
}

