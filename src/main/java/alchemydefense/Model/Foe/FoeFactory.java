package alchemydefense.Model.Foe;

/**
 * @author Willem Brahmstaedt
 * Date: 2021-09-14
 *
 * Factory class that creates Foe objects without exposing the creation logic to the client.
 *
 */


public class FoeFactory {
    public enum FoeTypes{
        CONCRETE_FOE
    }

    /**
     * Creates a specific Foe of a certain FoeType.
     * @param foeType Type of foe.
     * @return specific concrete Foe of that type.
     * @throws IllegalArgumentException
     * */

    public static Foe createFoe(FoeTypes foeType)  {
        if (foeType == FoeTypes.CONCRETE_FOE) {
            return new ConcreteFoe();
        }
        else
            throw new IllegalArgumentException();
    }
}
