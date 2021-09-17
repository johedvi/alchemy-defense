package alchemydefense.Model.Interfaces;

import java.awt.*;



//TODO: Separate this interface to smaller parts

public interface BoardObject {
    public Point getWorldPosition();
    public Point getCellPosition();
    public void setCellPosition(Point cell);
    public void setWorldPosition(Point cell);
    public void update();
}
