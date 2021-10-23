package ModelTest;

import alchemydefense.Model.GameModel;
import alchemydefense.Model.Player.Player;

import alchemydefense.Model.Towers.ITower;
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Model.Towers.TowerTransaction;
import alchemydefense.Utility.BoardObjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TowerTest {


    private static GameModel gameModel;
    private static Player player;


    @BeforeAll
    public static void setTowers(){
        player = new Player(100, 100);
    }

    @BeforeAll
    public static void setGameModel() {
        gameModel = new GameModel(12, 5);

    }

    @Test
    public void testBuyTowerFail() {
        ITower tower = TowerFactory.createTower(BoardObjectType.PURPLE_TOWER);
        Throwable exception = Assertions.assertThrows(Exception.class, () -> {

                 TowerTransaction.buyTower(tower,player); });

        Assertions.assertEquals("Not enough gold.", exception.getMessage());

        }



    @Test
    public void testImageFilePath() {
        ITower tower = TowerFactory.createTower(BoardObjectType.PURPLE_TOWER);
        Assertions.assertEquals("purple-crystal.png", tower.getImageFilePath());

        ITower tower1 = TowerFactory.createTower(BoardObjectType.RED_TOWER);
        Assertions.assertEquals("red-crystal.png", tower1.getImageFilePath());

        ITower tower2 = TowerFactory.createTower(BoardObjectType.GREEN_TOWER);
        Assertions.assertEquals("green-crystal.png", tower2.getImageFilePath());

        ITower tower3 = TowerFactory.createTower(BoardObjectType.BLUE_TOWER);
        Assertions.assertEquals("blue-crystal.png", tower3.getImageFilePath());

    }

    @Test
    public void testBoardObjectType() {
        ITower tower = TowerFactory.createTower(BoardObjectType.PURPLE_TOWER);
        Assertions.assertEquals(BoardObjectType.PURPLE_TOWER, tower.getBoardObjectType());

        ITower tower1 = TowerFactory.createTower(BoardObjectType.RED_TOWER);
        Assertions.assertEquals(BoardObjectType.RED_TOWER, tower1.getBoardObjectType());

        ITower tower2 = TowerFactory.createTower(BoardObjectType.GREEN_TOWER);
        Assertions.assertEquals(BoardObjectType.GREEN_TOWER, tower2.getBoardObjectType());


        ITower tower3 = TowerFactory.createTower(BoardObjectType.BLUE_TOWER);
        Assertions.assertEquals(BoardObjectType.BLUE_TOWER, tower3.getBoardObjectType());

    }














    }











