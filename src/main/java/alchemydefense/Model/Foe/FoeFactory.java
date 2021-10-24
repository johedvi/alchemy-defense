package alchemydefense.Model.Foe;

import alchemydefense.Utility.BoardObjectType;

/**
 * Factory class that creates Foe objects without exposing the creation logic to the client.
 *
 * @author Willem Brahmstaedt
 * Date: 2021-09-14
 *
 */
public class FoeFactory {

    /**
     * Creates a specific Foe of a certain FoeType.
     * @param foeType Type of foe.
     * @return specific concrete Foe of that type.
     * @throws IllegalArgumentException
     * */
    public static Foe createFoe(BoardObjectType foeType, int HP)  {
        if (foeType == BoardObjectType.CONCRETE_FOE) {
            return new ConcreteFoe(HP);
        }
        else
            throw new IllegalArgumentException();
    }
}
