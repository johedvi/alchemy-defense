package alchemydefense.Model.Player;

/**
 * Interface that the InformationView implements to change amount of health and gold on the screen.

 * */

public interface PlayerEventListener {
    void goldAmountChanged(int newValue);
    void healthAmountChanged(int newValue);
}
