package ModelTest;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.GameModel;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameModelTest {
    static GameModel model;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel(12,5);
    }

    @Test
    public void testTowerCreationFail() {
        model.placeTowerInCell(BoardObjectType.BLUE_TOWER, new Vector(2,2));
    }

    @Test
    public void testFoeStartingPlacement() {
        model.startNewWave();
        model.modelUpdate();
        Board board = model.getBoard();
        boolean foeCreated = false;

        for (int i = 0; i < board.getBoardHeight(); i++) {
            foeCreated = foeCreated || board.getTile(new Vector(0,i)).hasFoe();
        }

        Assertions.assertTrue(foeCreated);
    }
}
