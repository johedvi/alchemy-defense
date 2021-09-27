package alchemydefense.Model.Board;

import java.awt.*;

public interface Board {
    void placeBoardObject(BoardObject boardObject, Point cellCoordinate);
    BoardObject getBoardObject(Point cellCoordinate); // SHOULD RETURN A READ ONLY OBJECT PERHAPS?
    void removeBoardObject(Point cellCoordinate);
    int getBoardWidth();
    int getBoardHeight();
    void updateFoes();
}
