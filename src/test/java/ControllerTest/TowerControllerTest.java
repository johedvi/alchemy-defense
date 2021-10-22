package ControllerTest;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.AttackDamageSystem;
import alchemydefense.Model.Towers.PriceSystem;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TowerControllerTest {
    static GameModel model;
    static TowerController towerController;
    Tower testTower = new Tower(BoardObjectType.RED_TOWER, "red-crystal.png", new AttackDamageSystem(2,20), new PriceSystem(0,10));

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel(12,5);
        towerController = new TowerController(model);
    }

    @Test
    public void testIsHoldingTower() {
        towerController = new TowerController(model);
        Assertions.assertFalse(towerController.isHoldingTower());
        towerController.setGreenTowerActive();
        Assertions.assertTrue(towerController.isHoldingTower());
        towerController.setHoldingTowerFalse();
        Assertions.assertFalse(towerController.isHoldingTower());
    }

    @Test
    public void testSetActiveTower() {
        towerController.setBlueTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), BoardObjectType.BLUE_TOWER);
        towerController.setGreenTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), BoardObjectType.GREEN_TOWER);
        towerController.setPurpleTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), BoardObjectType.PURPLE_TOWER);
        towerController.setRedTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), BoardObjectType.RED_TOWER);
    }

    @Test
    public void testTowerCreation() {
        towerController.setRedTowerActive();
        towerController.createTower(new Vector(2,2));
        Assertions.assertEquals(testTower.getClass(), model.getBoardObjectInCell(new Vector(2,2)).getClass());
    }

    @Test
    public void testTowerPressed() {
        model.placeTowerInCell(BoardObjectType.RED_TOWER, new Vector(2,2));
        towerController.cellPressed(12, 5, 64, 160, 220);
        Assertions.assertTrue(towerController.isTowerPressed());
        towerController.setHoldingTowerFalse();
        towerController.cellPressed(12, 5, 64, 95, 220);
        Assertions.assertFalse(towerController.isTowerPressed());
    }

    @Test
    public void testSellTower() {
        model.placeTowerInCell(BoardObjectType.RED_TOWER, new Vector(2,2));

        towerController.cellPressed(12, 5, 64, 160, 220);

        Assertions.assertEquals(testTower.getClass(), model.getBoardObjectInCell(new Vector(2,2)).getClass());
        towerController.cellPressed(12, 5, 64, 160, 220);

        towerController.sellTower();
        Assertions.assertNull(model.getBoardObjectInCell(new Vector(2,2)));
    }
}
