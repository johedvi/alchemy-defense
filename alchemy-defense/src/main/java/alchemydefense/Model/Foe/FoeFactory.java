package alchemydefense.Model.Foe;

import alchemydefense.Model.Foe.Pathfinding.PathFinder;
import alchemydefense.Model.Interfaces.Foe;

public class FoeFactory {
    public enum FoeTypes{
        CONCRETE_FOE
    }

    public static Foe createFoe(FoeTypes foeType, PathFinder pathFinder, int boardHeight) {
        if (foeType == FoeTypes.CONCRETE_FOE) {
            return new ConcreteFoe(boardHeight, pathFinder);
        }
        else
            throw new IllegalArgumentException();
    }
}
