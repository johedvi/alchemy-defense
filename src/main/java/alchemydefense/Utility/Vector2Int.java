package alchemydefense.Utility;

public class Vector2Int{
    public int x;
    public int y;


    // Static convenience vectors for logic involving direction
    public static Vector2Int right(){
        return new Vector2Int(1,0);
    }

    public static Vector2Int left(){
        return new Vector2Int(-1,0);
    }

    public static Vector2Int up(){
        return new Vector2Int(0,1);
    }

    public static Vector2Int down(){
        return new Vector2Int(0,-1);
    }

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

    public void setVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setVector(Vector2Int vec) {
        this.x = vec.getX();
        this.y = vec.getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Vector2Int.class)
            return ((Vector2Int) obj).x == this.x && ((Vector2Int) obj).y == this.y;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 1000 * x + y;
    }

    public int getX() { return x; }

    public int getY() {
        return y;
    }
}
