package alchemydefense.Model.Player;


import java.util.ArrayList;

/**
 * @author Valdemar Stenhammar
 *
 * Singleton class representing a Player.
 *
 * Date: 2021-09-16
 *
 */

public class Player {

    private final ArrayList<PlayerEventListener> listeners = new ArrayList<>();

    private static final int GOLD_STARTING_VALUE = 100;
    private static final int HP_STARTING_VALUE = 100;

    private static int gold;
    private static int health;

    private static Player player;

    private Player(int gold, int health) {
        Player.gold = gold;
        Player.health = health;
    }

    public static Player getPlayer() {
        if(player == null) {
            return player = new Player(GOLD_STARTING_VALUE, HP_STARTING_VALUE);
        }
        return player;
    }

    public void decreaseOneHp() { setHp(health-1); }

    public void pay(int amount) {
        if(canAfford(amount)) {
            setGold(gold-amount);
        }
    }

    public boolean canAfford(int amount) { return gold > amount; }

    public void addPlayerEventListener(PlayerEventListener pel) { this.listeners.add(pel); }

    public void updatePlayerEventListener() {
        for (PlayerEventListener playerEventListener : listeners) {
            playerEventListener.goldAmountChanged(getGold());
            playerEventListener.healthAmountChanged(getHp());
        }
    }

    public int getGold() { return gold; }

    public void increaseGold(int amount) { setGold(gold + amount); }

    private void setGold(int amount) {
        gold = amount;
        updatePlayerEventListener();
    }

    public int getHp() { return health; }

    private void setHp(int hp) {
        health = hp;
        updatePlayerEventListener();
    }

}
