package ModelTest;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Towers.AttackDamageSystem;
import alchemydefense.Model.Towers.TowerFactory;
import alchemydefense.Model.Towers.Tower;
import alchemydefense.Utility.BoardObjectType;
import alchemydefense.Utility.Vector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    static Board board;
    static Vector vec;
    static TowerFactory towerFactory;

    @BeforeAll
    public static void beforeAll() {
        board = new ConcreteBoard(12,5);
        vec = new Vector(2,2);
    }

    @Test
    public void testMoveFoe() {
        board.getCell(vec).addFoe(new ConcreteFoe());
        board.updateFoes();
        Assertions.assertTrue(board.getCell(new Vector(3,2)).hasFoe());
    }

    @Test
    public void testDamageFoes() {
        board.getCell(vec).addFoe(new ConcreteFoe());
        board.placeTower(new Tower(BoardObjectType.RED_TOWER,"red-crystal.png", new AttackDamageSystem(2,20), priceSystem), new Vector(3,3));
        board.damageFoes();

        Assertions.assertEquals(80, board.getCell(vec).getFoe().getCurrentHP());
        int expectedGold = Player.getPlayer().getGold() + 10;
        // Check that killing the foe works as intended
        for (int i = 0; i < 9; i++) {
            board.damageFoes();
        }
        Assertions.assertEquals(expectedGold, Player.getPlayer().getGold());
        Assertions.assertFalse(board.getCell(vec).hasFoe());
    }

    @Test
    public void testAddFoe() {
        board.addFoe(new ConcreteFoe());
        boolean foeCreated = false;
        for (int i = 0; i < board.getBoardHeight(); i++)
            foeCreated = foeCreated || board.getCell(new Vector(0,i)).hasFoe();
        Assertions.assertTrue(foeCreated);
    }

    @Test
    public void testFoeReachedEnd() {
        GameModel model = new GameModel(12, 5);
        model.getBoard().getCell(new Vector(11,2)).addFoe(new ConcreteFoe());
        int expectedHP = Player.getPlayer().getHp() - 1;
        model.startNewWave();
        model.modelUpdate();
        Assertions.assertEquals(expectedHP, Player.getPlayer().getHp());
    }
}
