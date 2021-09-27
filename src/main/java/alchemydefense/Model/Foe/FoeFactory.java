package alchemydefense.Model.Foe;

import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Foe;

import java.io.FileNotFoundException;

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
