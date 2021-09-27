package alchemydefense.Utility;

public class Vector2Int{
    public int x;
    public int y;

    public static int distanceBetweenVectorPoints(Vector2Int vector1, Vector2Int vector2){
        double distanceX = Math.pow(vector1.x - vector2.x, 2);
        double distanceY = Math.pow(vector1.y - vector2.y, 2);
        return (int)Math.sqrt(distanceX + distanceY);
    }

    public Vector2Int(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x +", " + y + ")";
    }
}
