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











    @Test
    public void testBuyTowerFail() {

        Throwable exception = Assertions.assertThrows(Exception.class, () -> {
                new TowerTransaction().buyTower(BoardObjectType.PURPLE_TOWER); });
        Assertions.assertEquals("Not enough gold.", exception.getMessage());

        }

/*
    @Test
    public void testToStringAllTowers() {
        Assertions.assertEquals("Blue Tower", blueTower.toString());
        Assertions.assertEquals("Red Tower", redTower.toString());
        Assertions.assertEquals("Green Tower", greenTower.toString());
        Assertions.assertEquals("Purple Tower", purpleTower.toString());

    }

    @Test
    public void testImageFilePath() {
        Assertions.assertEquals("blue-crystal.png", Tower.getImageFilePath());
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


*/









    }











