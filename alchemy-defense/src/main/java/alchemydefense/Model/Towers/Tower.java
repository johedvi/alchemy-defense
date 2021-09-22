package alchemydefense.Model.Towers;
import alchemydefense.Model.Interfaces.BoardObject;
import java.awt.*;


/**
 * @author Johan Lindén
 * @date: 2021-09-14
 *
 * A class for an abstract tower. Concrete towers extends this class. Handles
 * all the shared logic of towers. Implements BoardObject.
 *
 *----- Modified ------
 * Date 09-19, By Willem; Removed position attributes and methods associated with them
 *
 */

public abstract class Tower implements BoardObject {

    int width;
    int height;
    int range;

    public int getRange(){
        return range;
    }

    public enum TowerType {

        RED, BLUE, GREEN, PURPLE

    }


    public Tower() {
    }



    public void update() {
        //TODO
    }

}
