package ModelTest;

import alchemydefense.Model.GameModel;
import alchemydefense.Utility.TowerType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameModelTest {
    static GameModel model;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel();
    }

    @Test
    public void testTowerCreationFail() {
        model.placeTowerInCell(TowerType.BLUE, new Vector(2,2));
    }
}
