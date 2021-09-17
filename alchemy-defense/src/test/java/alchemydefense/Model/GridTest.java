package alchemydefense.Model;

import alchemydefense.Model.Board.Grid.PositionalGrid;
import alchemydefense.Model.Interfaces.BoardObject;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Utility.PixelRatios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GridTest {
    private static GameModel gameModel;
    Point testPoint;
    PixelRatios pixelRatios;

    @BeforeAll
    static void setGameModel(){
        gameModel = new GameModel();
    }

    @Test
    public void testPlaceTowerInCell(){
        testPoint = new Point(1,1);
        gameModel.placeTowerInCell(testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), Tower.class);
    }

    @Test
    public void testRemoveTowerFromCell(){
        testPoint = new Point(3,3);
        gameModel.placeTowerInCell(testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), Tower.class);
        gameModel.removeBoardObjectInCell(testPoint);
        Assertions.assertNull(gameModel.getBoardObjectInCell(testPoint));
    }

    @Test
    public void testTowerSyncWithCellPosition(){
        testPoint = new Point(2,2);
        gameModel.placeTowerInCell(testPoint);
        BoardObject tower = gameModel.getBoardObjectInCell(testPoint);
        Assertions.assertEquals(testPoint, tower.getCellPosition());
    }

    //TODO: Fix with tower code

    /*
    @Test
    public void testTowerSyncWithWorldPosition(){
        PositionalGrid testGrid = new PositionalGrid(3,3);
        testPoint = new Point(2,2);
        Tower testTower = new Tower();
        testGrid.add(testTower, testPoint);
        Point middleOfTheCellInWorldSpace = new Point(64 * 2, 64 * 2);
        Assertions.assertEquals(middleOfTheCellInWorldSpace, testTower.getWorldPosition());
    }


     */
}
