package alchemydefense.Model.Player;


import java.util.ArrayList;

/**
 * Class representing a Player.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-16
 *
 */
public class Player {

    private final ArrayList<PlayerEventListener> listeners = new ArrayList<>();

    private static int gold;
    private static int health;

    /**
     * Constructor that creates a new player with requested amount of gold and hp.
     * @param goldStartingValue how much gold the player starts with.
     * @param healthStartingValue how much health the player starts with.
     */
    public Player(int goldStartingValue, int healthStartingValue) {
        Player.gold = goldStartingValue;
        Player.health = healthStartingValue;
    }

    /**
     * If player can afford, pay amount.
     * @param amount the amount to charge the player.
     */
    public void pay(int amount) {
        if(canAfford(amount)) {
            setGold(gold-amount);
        }
    }

    /**
     * Checks if the amount is less than the players current gold value.
     * @param amount the amount to compare against the players gold.
     * @return true if gold is bigger that or equal to amount, else false.
     */
    public boolean canAfford(int amount) { return gold >= amount; }

    /**
     * Increases the players gold value.
     * @param amount the amount to increase the players gold value with.
     */
    public void increaseGold(int amount) { setGold(gold + amount); }

    /**
     * Decreases players health value by one.
     */
    public void decreaseOneHp() { setHp(health-1); }

    public void addPlayerEventListener(PlayerEventListener pel) {
        this.listeners.add(pel);
        updatePlayerEventListener();
    }

    private void updatePlayerEventListener() {
        for (PlayerEventListener playerEventListener : listeners) {
            playerEventListener.goldAmountChanged(getGold());
            playerEventListener.healthAmountChanged(getHp());
        }
    }

    private void setGold(int amount) {
        gold = amount;
        updatePlayerEventListener();
    }

    private void setHp(int hp) {
        health = hp;
        updatePlayerEventListener();
    }

    public int getGold() { return gold; }

    public int getHp() { return health; }
}
