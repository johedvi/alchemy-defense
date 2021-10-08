package ModelTest;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerHierarchy.RedTower;
import alchemydefense.Utility.BoardObjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import alchemydefense.Utility.Vector;

public class GridTest {
    private static GameModel gameModel;
    Vector testPoint;

    @BeforeAll
    public static void setGameModel(){
        gameModel = new GameModel();
    }

    @Test
    public void testPlaceTowerInCell(){
        testPoint = new Vector(1,1);
        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
    }

    @Test
    public void testRemoveTowerFromCell(){
        testPoint = new Vector(3,3);
        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
        gameModel.removeBoardObjectInCell(testPoint);
        Assertions.assertNull(gameModel.getBoardObjectInCell(testPoint));
    }
}
