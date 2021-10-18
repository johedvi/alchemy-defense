package ModelTest;

import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.Grid.Tile;
import alchemydefense.Model.Board.Grid.TileGrid;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.BoardObjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import alchemydefense.Utility.Vector;

public class GridTest {
    private static GameModel gameModel;
    private static ConcreteBoard board;
    Vector testPoint;
    Tower testTower = new Tower(BoardObjectType.RED_TOWER, "red-crystal.png",2,20);


    @BeforeAll
    public static void setGameModel(){
        gameModel = new GameModel(12,5);
        board = new ConcreteBoard(12,5);
    }

    @Test
    public void testPlaceTowerInCell(){

        testPoint = new Vector(1,1);
        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(),testTower.getClass());
    }

    @Test
    public void testRemoveTowerFromCell(){
        testPoint = new Vector(3,3);

        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), testTower.getClass());
        gameModel.removeBoardObjectInCell(testPoint);
        Assertions.assertNull(gameModel.getBoardObjectInCell(testPoint));
    }
    @Test
    public void testCellsInRange() {
        Assertions.assertEquals(0,board.getCell(new Vector(2,2)).getPositionalCellsWithinRange(board).size());
        board.placeTower(new Tower(BoardObjectType.RED_TOWER,"red-crystal.png",2,20), new Vector(2,2));
        Assertions.assertEquals(12,board.getCell(new Vector(2,2)).getPositionalCellsWithinRange(board).size());
    }

    @Test
    public void testFoeInCell() {
        Tile tile = new Tile(2,2);

        Assertions.assertFalse(tile.hasFoe());
        tile.addFoe(new ConcreteFoe());
        Assertions.assertTrue(tile.hasFoe());
        tile.removeFoe();
        Assertions.assertFalse(tile.hasFoe());
    }

    @Test
    public void testToString() {
        Tile tile = new Tile(2,2);

        Assertions.assertEquals("(2, 2)", tile.toString());
    }

    @Test
    public void testUpdateFlag() {
        Tile tile = new Tile(2,2);

        Assertions.assertFalse(tile.isUpdated());
        tile.setUpdated(true);
        Assertions.assertTrue(tile.isUpdated());
    }

    @Test
    public void testAddFoe() {
        TileGrid grid = new TileGrid(12,5);
        Vector test = new Vector(1,1);

        grid.addFoe(new ConcreteFoe(), test);
        Assertions.assertTrue(grid.getCell(test).hasFoe());
    }
}
