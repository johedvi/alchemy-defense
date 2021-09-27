import alchemydefense.Utility.Vector2Int;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class VectorTest {
    Vector2Int vectorCenter;
    Vector2Int vector2;
    Vector2Int vector3;

    @Test
    public void testDistanceRange1(){
        vectorCenter = new Vector2Int(2,2);
        vector2 = new Vector2Int(3,1);
        vector3 = new Vector2Int(3,2);
        int distance1 = Vector2Int.distanceBetweenVectorPoints(vectorCenter, vector2);
        int distance2 = Vector2Int.distanceBetweenVectorPoints(vectorCenter, vector3);
        Assert.assertEquals(distance1, distance2);
        Assert.assertEquals(1, distance1);
    }

    @Test
    public void testDistanceRange2(){
        //Could merge this method with above in some way
        vectorCenter = new Vector2Int(2,2);
        vector2 = new Vector2Int(4,0);
        vector3 = new Vector2Int(4,2);
        int distance1 = Vector2Int.distanceBetweenVectorPoints(vectorCenter, vector2);
        int distance2 = Vector2Int.distanceBetweenVectorPoints(vectorCenter, vector3);
        Assert.assertEquals(distance1, distance2);
        Assert.assertEquals(2, distance1);
    }
}
