package alchemydefense.Model.Player;

/**
 * Interface for the player to notify a change in the players status.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-21
 */

public interface PlayerEventListener {

    /**
     * Tells all PlayerEventListeners that the players current gold has been updated.
     * @param newValue the players new gold value.
     */
    void goldAmountChanged(int newValue);

    /**
     * Tells all PlayerEventListeners that the players current health has been updated.
     * @param newValue the players new health value.
     */
    void healthAmountChanged(int newValue);
}
