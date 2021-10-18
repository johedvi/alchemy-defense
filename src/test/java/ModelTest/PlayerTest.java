package ModelTest;

import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    static Player player = Player.getPlayer();

    @Test
    public void playerEventListenerTest() {
        PlayerEventListenerTest playerListenerTest = new PlayerEventListenerTest();
        player.addPlayerEventListener(playerListenerTest);
        player.pay(player.getGold());
        Assertions.assertEquals(0, playerListenerTest.gold);

        int health = player.getHp() - 1;
        player.decreaseOneHp();
        Assertions.assertEquals(health, playerListenerTest.health);
    }

    static class PlayerEventListenerTest implements PlayerEventListener {
        int gold, health;

        @Override
        public void goldAmountChanged(int newValue) {
            this.gold = newValue;
        }

        @Override
        public void healthAmountChanged(int newValue) {
            this.health = newValue;
        }
    }
}


