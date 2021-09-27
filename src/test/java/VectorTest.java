import alchemydefense.Utility.Vector2Int;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class VectorTest {
    Vector2Int vector1;
    Vector2Int vector2;

    @Test
    public void testDistance(){
        int range = 2; //
        vector1 = new Vector2Int(0,0);
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                if(Math.abs(x) != range && Math.abs(y) != range){
                    continue;
                }
                System.out.println(x + " " + y);

            }
        }
    }
}
