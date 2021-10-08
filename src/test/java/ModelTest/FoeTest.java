package ModelTest;

import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Foe.FoeFactory;
import alchemydefense.Utility.BoardObjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Willem Brahmstaedt
 * Class for testing ConcreteFoe
 *
 * Date: 2021-09-14
 */

public class FoeTest {
    static int boardHeight;
    static Foe foe;
    static final int maxHP = 100;


    @BeforeAll
    public static void beforeTestMethod() {
        boardHeight = 200;
        foe = FoeFactory.createFoe(BoardObjectType.CONCRETE_FOE);
    }

    @Test
    public void testFoeCreation() {
        Assertions.assertEquals(FoeFactory.createFoe(BoardObjectType.CONCRETE_FOE).getClass(), ConcreteFoe.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FoeFactory.createFoe(null).getClass();
        });
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

    @Test
    public void testToString() {
        Assertions.assertEquals("ConcreteFoe", foe.toString());
    }

    @Test
    public void testImageFilePath() {
        Assertions.assertEquals("/foe.png", foe.getImageFilePath());
    }

}
