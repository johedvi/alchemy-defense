package ModelTest;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.Tower;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameModelTest {
    static GameModel model;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel();
    }

    @Test
    public void testTowerCreationFail() {
        model.placeTowerInCell(Tower.TowerType.BLUE, new Point(2,2));
    }
}
