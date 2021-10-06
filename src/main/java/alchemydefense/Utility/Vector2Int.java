package alchemydefense.Utility;

/**
 * Class representing a two-dimensional vector.
 *
 * @author Felix Jönsson
 */
public class Vector2Int{
    public int x;
    public int y;

    // Static convenience vectors for logic involving direction

    /**
     * Convenience method.
     * @return new Vector(1,0)
     */
    public static Vector2Int right(){
        return new Vector2Int(1,0);
    }

    /**
     * Convenience method.
     * @return new Vector(-1,0)
     */
    public static Vector2Int left(){
        return new Vector2Int(-1,0);
    }

    /**
     * Convenience method.
     * @return new Vector(0,1)
     */
    public static Vector2Int up(){
        return new Vector2Int(0,1);
    }

    /**
     * Convenience method.
     * @return new Vector(0,-1)
     */
    public static Vector2Int down(){
        return new Vector2Int(0,-1);
    }

    /**
     * Calculates the distance between two int vectors and trunks the result.
     * @param vector1
     * @param vector2
     * @return the absolut value of the distance trunked to the nearest integer.
     */
    public static int distanceBetweenVectorPoints(Vector2Int vector1, Vector2Int vector2){
        double distanceX = Math.pow(vector1.x - vector2.x, 2);
        double distanceY = Math.pow(vector1.y - vector2.y, 2);
        return (int)Math.sqrt(distanceX + distanceY);
    }

    /**
     * Creates a new vector with integer values.
     * @param x x-value
     * @param y y-value
     */
    public Vector2Int(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x +", " + y + ")";
    }

    /**
     * Updates a vector with new x- and y-values.
     * @param x
     * @param y
     */
    public void setVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copies the values from the paramater vector to the current.
     * @param vector vector to copy values from
     */
    public void setVector(Vector2Int vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    /**
     * Return true if the x- and y-values are the same.
     * @param obj vector to compare
     * @return boolean indicating if the equal is true or not
     */
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
