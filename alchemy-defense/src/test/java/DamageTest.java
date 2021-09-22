import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.Grid.PositionalCell;
import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.TestFoe;
import alchemydefense.Model.Interfaces.Board;
import alchemydefense.Model.Interfaces.Foe;
import alchemydefense.Model.Towers.TestTower;
import alchemydefense.Model.Towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DamageTest {

    ConcreteBoard board;
    Tower tower;
    TestFoe foe;

    //Placera ut ett torn range 3
    //Placera ut en fiende inom abs(3)
    //Placera ut en fiende utanför abs(3), t.ex. 4

    @BeforeEach
    public void setup(){
        board = new ConcreteBoard();
        tower = new TestTower();
        foe = new TestFoe();
    }

    @Test
    public void testDamage(){
    }

}
