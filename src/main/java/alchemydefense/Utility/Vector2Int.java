package alchemydefense.Utility;

public class Vector2Int{
    public int x;
    public int y;

    public static int distanceBetweenVectorPoints(Vector2Int vector1, Vector2Int vector2){
        int distanceX = Math.abs(vector1.x - vector2.x);
        int distanceY = Math.abs(vector1.y - vector2.y);
        return (int)Math.sqrt(distanceX + distanceY);
    }

    public Vector2Int(int x, int y){
        this.x = x;
        this.y = y;
    }
}
