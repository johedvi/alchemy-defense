package alchemydefense.Model.Board;

/**
 * Interface for the board to render objects.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */
public interface BoardListener {

    /**
     * Tells all BoardListeners to render the board.
     * @param board the board that should be rendered.
     */
    void renderObjects(Board board);
}
