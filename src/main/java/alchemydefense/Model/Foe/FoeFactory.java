package alchemydefense.Model.Foe;

public class FoeFactory {
    public enum FoeTypes{
        CONCRETE_FOE
    }

    public static Foe createFoe(FoeTypes foeType)  {
        if (foeType == FoeTypes.CONCRETE_FOE) {
            return new ConcreteFoe();
        }
        else
            throw new IllegalArgumentException();
    }
}
