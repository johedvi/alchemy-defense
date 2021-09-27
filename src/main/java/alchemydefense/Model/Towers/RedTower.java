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
    private static int RedTowerRange = 3;

        public RedTower() throws FileNotFoundException {
        super();
        Type = TowerType.RED;
        this.height = RedTowerHeight;
        this.width = RedTowerWidth;
        this.range = RedTowerRange;
        this.filePath = "blue-crystal.png";
        this.damage = 10;
    }

    @Override
    public String toString(){
            return "Red Tower";
    }


    @Override
    public String getImageFilePath() {
        return filePath;
    }
}

