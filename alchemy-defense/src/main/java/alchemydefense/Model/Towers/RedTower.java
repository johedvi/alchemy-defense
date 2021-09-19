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
    Image image;

    private static int RedTowerHeight = 100;
    private static int RedTowerWidth = 100;
    private static int RedTowerRange = 100;

    FileInputStream inputstream = new FileInputStream("C:\\images\\image.jpg");

    public RedTower() throws FileNotFoundException {
        super();
        Type = TowerType.RED;
        image = new Image(inputstream);
        this.height = RedTowerHeight;
        this.width = RedTowerWidth;
        this.range = RedTowerRange;
    }
}

