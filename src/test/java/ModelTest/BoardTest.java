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
    static Board board;
    static Vector vec;

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
        board.placeTower(new RedTower(), new Vector(3,3));
        board.damageFoes();

        Assertions.assertEquals(90, board.getCell(vec).getFoe().getCurrentHP());

        for (int i = 0; i < 9; i++) {
            board.damageFoes();
        }

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
        model.getBoard().getCell(new Vector(11,3)).addFoe(new ConcreteFoe());
        model.modelUpdate();
        Assertions.assertEquals(99, Player.getPlayer().getHp());
    }
}
