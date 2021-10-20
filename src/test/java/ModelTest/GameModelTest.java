package ModelTest;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.ITower;
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameModelTest {
    static GameModel model;
    static ITower tower;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel(12,5);
    }

    @Test
    public void testTowerCreationFail() {
        tower = TowerFactory.createTower(BoardObjectType.PURPLE_TOWER);
        model.placeTowerInCell(tower, new Vector(2,2));
    }

    @Test
    public void testFoeStartingPlacement() {
        model.startNewWave();
        model.modelUpdate();
        Board board = model.getBoard();
        boolean foeCreated = false;

        for (int i = 0; i < board.getBoardHeight(); i++) {
            foeCreated = foeCreated || board.getCell(new Vector(0,i)).hasFoe();
        }

        Assertions.assertTrue(foeCreated);
    }
}
