package ModelTest;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerHierarchy.RedTower;
import alchemydefense.Model.Towers.TowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import alchemydefense.Utility.Vector2Int;

public class GridTest {
    private static GameModel gameModel;
    Vector2Int testPoint;

    @BeforeAll
    public static void setGameModel(){
        gameModel = new GameModel();
    }

    @Test
    public void testPlaceTowerInCell(){
        testPoint = new Vector2Int(1,1);
        gameModel.placeTowerInCell(TowerType.RED, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
    }

    @Test
    public void testRemoveTowerFromCell(){
        testPoint = new Vector2Int(3,3);
        gameModel.placeTowerInCell(TowerType.RED, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
        gameModel.removeBoardObjectInCell(testPoint);
        Assertions.assertNull(gameModel.getBoardObjectInCell(testPoint));
    }
}
