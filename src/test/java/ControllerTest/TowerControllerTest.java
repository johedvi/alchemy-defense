package ControllerTest;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.RedTower;
import alchemydefense.Model.Towers.Tower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TowerControllerTest {
    static GameModel model;
    static TowerController towerController;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel();
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
        Assertions.assertEquals(towerController.getActiveTower(), Tower.TowerType.BLUE);
        towerController.setGreenTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), Tower.TowerType.GREEN);
        towerController.setPurpleTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), Tower.TowerType.PURPLE);
        towerController.setRedTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), Tower.TowerType.RED);
    }

    @Test
    public void testTowerCreation() {
        towerController.setRedTowerActive();
        towerController.createTower(2,2);
        Assertions.assertEquals(RedTower.class, model.getBoardObjectInCell(new Point(2,2)).getClass());
    }
}
