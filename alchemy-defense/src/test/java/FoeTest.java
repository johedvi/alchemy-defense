import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.DumbPathfinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;
import java.io.FileNotFoundException;

/**
 * @author Willem Brahmstaedt
 * Class for testing ConcreteFoe
 *
 * Date: 2021-09-14
 */

public class FoeTest {
    static int boardHeight;
    static ConcreteFoe foe;
    static final int maxHP = 100;

    @BeforeAll
    public static void beforeTestMethod() throws FileNotFoundException {
        boardHeight = 200;
        foe = new ConcreteFoe(boardHeight, new DumbPathfinder(new Point(0,0)), 10);
    }


    @Test
    public void testFoeSpawnInBoardHeight() {

        Assertions.assertTrue(0 <= foe.getCellPosition().y && foe.getCellPosition().y <= boardHeight);
    }

    /**
     * Test whether it survives damage lower than its maxHP, currentHP updates as expected
     * and whether it indicates that it dies when more damage is taken than there is HP left
     */
    @Test
    public void testDamageTaken() {
        Assertions.assertEquals(foe.getMaxHP(), maxHP);

        int damageCount = 78;
        foe.takeDamage(damageCount);
        Assertions.assertTrue(foe.isAlive());

        Assertions.assertEquals(foe.getCurrentHP(), maxHP - damageCount);

        foe.takeDamage(23);
        Assertions.assertFalse(foe.isAlive());
    }
}
