package alchemydefense.Utility;

/**
 * Enum representing different board object types.
 *
 * @author Johan Linden
 *
 * Date: 2021-09-11
 */
public enum BoardObjectType {
    RED_TOWER, BLUE_TOWER, GREEN_TOWER, PURPLE_TOWER,

    CONCRETE_FOE;

    @Override
    public String toString() {
        String string;
        switch (this) {
            case RED_TOWER: string = "Red Tower"; break;
            case BLUE_TOWER: string = "Blue Tower"; break;
            case GREEN_TOWER: string = "Green Tower"; break;
            case PURPLE_TOWER: string = "Purple Tower"; break;
            case CONCRETE_FOE: string = "Concrete Foe"; break;
            default: string = "BoardObjectType not found";
        }
        return string;
    }



}