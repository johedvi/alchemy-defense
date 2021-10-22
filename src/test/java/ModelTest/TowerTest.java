package ModelTest;

<<<<<<< HEAD
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Player.Player;
=======
import alchemydefense.Model.Towers.ITower;
>>>>>>> towerRefactor
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Model.Towers.TowerTransaction;
import alchemydefense.Utility.BoardObjectType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class TowerTest {

<<<<<<< HEAD
    private static GameModel gameModel;
    private static Vector testPoint;
    private static BlueTower blueTower;
    private static RedTower redTower;
    private static GreenTower greenTower;
    private static PurpleTower purpleTower;
    private static Player player;


    @BeforeAll
    public static void setTowers(){
        blueTower = new BlueTower();
        redTower = new RedTower();
        greenTower = new GreenTower();
        purpleTower = new PurpleTower();
        player = new Player(100, 100);
    }

    @BeforeAll
    public static void setGameModel() {
        gameModel = new GameModel(12,5);
=======
>>>>>>> towerRefactor





<<<<<<< HEAD
        player.increaseGold(800);
=======
>>>>>>> towerRefactor





    @Test
    public void testBuyTowerFail() {
        ITower tower = TowerFactory.createTower(BoardObjectType.PURPLE_TOWER);
        Throwable exception = Assertions.assertThrows(Exception.class, () -> {
<<<<<<< HEAD
                TowerTransaction.buyTower(player, BoardObjectType.PURPLE_TOWER); });
=======
                new TowerTransaction().buyTower(tower); });
>>>>>>> towerRefactor
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











