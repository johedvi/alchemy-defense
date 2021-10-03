package ModelTest;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DamageTest {

    ConcreteBoard board;
    Tower tower;

    //Placera ut ett torn range 3
    //Placera ut en fiende inom abs(3)
    //Placera ut en fiende utanför abs(3), t.ex. 4

    @BeforeEach
    public void setup(){
        board = new ConcreteBoard();
    }

    @Test
    public void testDamage(){
    }

}
