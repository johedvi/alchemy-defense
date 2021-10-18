package ModelTest;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Model.Towers.TowerHierarchy.*;
import alchemydefense.Model.Towers.TowerPrices;
import alchemydefense.Model.Towers.TowerTransaction;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.sound.midi.SysexMessage;

public class TowerTest {

    private static GameModel gameModel;
    private static Vector testPoint;
    private static BlueTower blueTower;
    private static RedTower redTower;
    private static GreenTower greenTower;
    private static PurpleTower purpleTower;


    @BeforeAll
    public static void setTowers(){
        blueTower = new BlueTower();
        redTower = new RedTower();
        greenTower = new GreenTower();
        purpleTower = new PurpleTower();

    }

    @BeforeAll
    public static void setGameModel() {
        gameModel = new GameModel();

    }

    @BeforeAll
    public static void setVector() {
        testPoint = new Vector(1, 1);
    }


    @Test
    public void testAllTowers() {


        Player.getPlayer().increaseGold(800);

        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
        gameModel.removeBoardObjectInCell(testPoint);

        gameModel.placeTowerInCell(BoardObjectType.BLUE_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), BlueTower.class);
        gameModel.removeBoardObjectInCell(testPoint);

        gameModel.placeTowerInCell(BoardObjectType.GREEN_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), GreenTower.class);
        gameModel.removeBoardObjectInCell(testPoint);

        gameModel.placeTowerInCell(BoardObjectType.PURPLE_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), PurpleTower.class);
    }

    @Test
    public void testRemoveTowerFromCell() {
        gameModel.removeBoardObjectInCell(testPoint);

        gameModel.placeTowerInCell(BoardObjectType.RED_TOWER, testPoint);
        Assertions.assertEquals(gameModel.getBoardObjectInCell(testPoint).getClass(), RedTower.class);
        gameModel.removeBoardObjectInCell(testPoint);
        Assertions.assertNull(gameModel.getBoardObjectInCell(testPoint));
    }


    @Test
    public void testBuyTowerFail() {

        Throwable exception = Assertions.assertThrows(Exception.class, () -> {
                new TowerTransaction().buyTower(BoardObjectType.PURPLE_TOWER); });
        Assertions.assertEquals("Not enough gold.", exception.getMessage());

        }


    @Test
    public void testToStringAllTowers() {
        Assertions.assertEquals("Blue Tower", blueTower.toString());
        Assertions.assertEquals("Red Tower", redTower.toString());
        Assertions.assertEquals("Green Tower", greenTower.toString());
        Assertions.assertEquals("Purple Tower", purpleTower.toString());

    }

    @Test
    public void testImageFilePath() {
        Assertions.assertEquals("blue-crystal.png", blueTower.getImageFilePath());
        Assertions.assertEquals("red-crystal.png", redTower.getImageFilePath());
        Assertions.assertEquals("green-crystal.png", greenTower.getImageFilePath());
        Assertions.assertEquals("purple-crystal.png", purpleTower.getImageFilePath());
    }

    @Test
    public void testGetTowerRange() {
        Assertions.assertEquals(2, blueTower.getRange());
        Assertions.assertEquals(2, redTower.getRange());
        Assertions.assertEquals(3, greenTower.getRange());
        Assertions.assertEquals(3, purpleTower.getRange());
    }

    @Test
    public void testGetTowerDamage() {
        Assertions.assertEquals(20, blueTower.getDamage());
        Assertions.assertEquals(10, redTower.getDamage());
        Assertions.assertEquals(20, greenTower.getDamage());
        Assertions.assertEquals(30, purpleTower.getDamage());
    }

    @Test
    public void testGetSellPrice() {
        Assertions.assertEquals(10, TowerPrices.getInstance().getSellPrice(BoardObjectType.RED_TOWER));
        Assertions.assertEquals(20, TowerPrices.getInstance().getSellPrice(BoardObjectType.BLUE_TOWER));
        Assertions.assertEquals(40, TowerPrices.getInstance().getSellPrice(BoardObjectType.GREEN_TOWER));
        Assertions.assertEquals(80, TowerPrices.getInstance().getSellPrice(BoardObjectType.PURPLE_TOWER));
    }

    @Test
    public void TowerFactoryTest() {
        Assertions.assertEquals(TowerFactory.createTower(BoardObjectType.PURPLE_TOWER).getClass(), PurpleTower.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TowerFactory.createTower(BoardObjectType.CONCRETE_FOE);
        });
    }








    }











