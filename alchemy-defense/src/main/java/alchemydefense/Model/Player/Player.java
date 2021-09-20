package alchemydefense.Model.Player;


/**
 * @author Valdemar Stenhammar
 *
 * Singleton class representing a Player.
 *
 * Date: 2021-09-16
 *
 */

public class Player {

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

    public int getGold() { return gold; }

    public void setGold(int gold) { Player.gold = gold; }

    public int getHp() { return health; }

    public void setHp(int hp) { Player.health = hp; }

}
