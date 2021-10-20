package ModelTest;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.TowerHierarchy.RedTower;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    static Player player;
    static Board board;
    static Vector vec;

    @BeforeAll
    public static void beforeAll() {
        player = new Player(100, 100);
        board = new ConcreteBoard(player,12,5);
        vec = new Vector(2,2);
    }

    @Test
    public void testMoveFoe() {
        board.getTile(vec).addFoe(new ConcreteFoe());
        board.updateFoes();
        Assertions.assertTrue(board.getTile(new Vector(3,2)).hasFoe());
    }

    @Test
    public void testDamageFoes() {
        board.getTile(vec).addFoe(new ConcreteFoe());
        board.placeTower(new RedTower(), new Vector(3,3));
        board.damageFoes();

        Assertions.assertEquals(90, board.getTile(vec).getFoe().getCurrentHP());
        int expectedGold = player.getGold() + 10;
        // Check that killing the foe works as intended
        for (int i = 0; i < 9; i++) {
            board.damageFoes();
        }
        Assertions.assertEquals(expectedGold, player.getGold());
        Assertions.assertFalse(board.getTile(vec).hasFoe());
    }

    @Test
    public void testAddFoe() {
        board.addFoe(new ConcreteFoe());
        boolean foeCreated = false;
        for (int i = 0; i < board.getBoardHeight(); i++)
            foeCreated = foeCreated || board.getTile(new Vector(0,i)).hasFoe();
        Assertions.assertTrue(foeCreated);
    }

    @Test
    public void testFoeReachedEnd() {
        GameModel model = new GameModel(12, 5);
        model.getBoard().getTile(new Vector(11,2)).addFoe(new ConcreteFoe());
        int expectedHP = player.getHp() - 1;
        model.startNewWave();
        model.modelUpdate();
        Assertions.assertEquals(expectedHP, player.getHp());
    }
}
