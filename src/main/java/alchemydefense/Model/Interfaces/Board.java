package alchemydefense.Model.Interfaces;

import java.awt.*;

public interface Board {
    public void placeBoardObject(BoardObject boardObject, Point cellCoordinate);
    public BoardObject getBoardObject(Point cellCoordinate); // SHOULD RETURN A READ ONLY OBJECT PERHAPS?
    public void removeBoardObject(Point cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void updateFoes();
}
