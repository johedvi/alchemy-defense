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

    public boolean pay(int amount) {
        if(canAfford(amount)) {
            setGold(gold-amount);
            return true;
        }
        return false;
    }

    private boolean canAfford(int amount) { return gold > amount; }

    public void addPlayerEventListener(PlayerEventListener pel) { this.listeners.add(pel); }

    public int getGold() { return gold; }

    private void setGold(int gold) {
        Player.gold = gold;
        for(PlayerEventListener pel : listeners) {
            pel.goldAmountChanged(gold);
        }
    }

    public int getHp() { return health; }

    private void setHp(int hp) {
        Player.health = hp;
        for(PlayerEventListener pel : listeners) {
            pel.heathAmountChanged(hp);
        }
    }

}
