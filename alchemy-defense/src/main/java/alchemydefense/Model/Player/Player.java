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
    private static int hp;

    private static Player player;

    private Player(int gold, int hp) {
        Player.gold = gold;
        Player.hp = hp;
    }

    public static Player getPlayer() {
        if(player == null) {
            return player = new Player(GOLD_STARTING_VALUE, HP_STARTING_VALUE);
        }
        return player;
    }

    public int getGold() { return gold; }

    public void setGold(int gold) { Player.gold = gold; }

    public int getHp() { return hp; }

    public void setHp(int hp) { Player.hp = hp; }

}
