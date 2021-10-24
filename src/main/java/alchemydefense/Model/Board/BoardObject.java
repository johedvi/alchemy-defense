package alchemydefense.Model.Board;

import alchemydefense.Utility.BoardObjectType;

/**
 * Interface for any object which represents a BoardObject.
 *
 * @author Willem Brahmstaedt
 *
 * Date: 2021-09-14
 */

public interface BoardObject {

    String getImageFilePath();

    BoardObjectType getBoardObjectType();


}
