package alchemydefense.Utility;

/**
 * Class representing a two-dimensional vector.
 *
 * @author Felix Jönsson
 */

public class Vector2Int {
    private int x;
    private int y;

    /**
     * Constructor that assigns the object an X- and Y-value.
     * @param x the x value.
     * @param y the y value.
     */
    public Vector2Int(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between two vectors.
     * @param vector1 the first vector.
     * @param vector2 the second vector.
     * @return the distance between vector1 and vector2.
     */
    public static int distanceBetweenVectorPoints(Vector2Int vector1, Vector2Int vector2){
        double distanceX = Math.pow(vector1.x - vector2.x, 2);
        double distanceY = Math.pow(vector1.y - vector2.y, 2);
        return (int)Math.sqrt(distanceX + distanceY);
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
    public String toString(){
        return "(" + x +", " + y + ")";
    }

    public int getX() { return x; }

    public int getY() {
        return y;
    }
}
