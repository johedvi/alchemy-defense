package ModelTest;

import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Foe.Wave;
import alchemydefense.Model.Foe.WaveListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class WaveTest {
    @Test
    public void testWaveCreation() {
        WaveTestListener waveTestListener = new WaveTestListener();
        Wave.addWaveListener(waveTestListener);
        int expectedWaveCounter = waveTestListener.waveCounter + 1;
        Wave wave = new Wave();
        Assertions.assertEquals(expectedWaveCounter,waveTestListener.waveCounter);
    }

    @Test
    public void testFoeCreation() {
        Wave wave = new Wave();
        LinkedList<Foe> foeList = wave.createFoes();
        WaveTestListener waveTestListener = new WaveTestListener();
        Wave.addWaveListener(waveTestListener);
        int expectedFoeAmount = (int) (10 * Math.pow(1.1, waveTestListener.waveCounter) - 1) + 1;

        Assertions.assertEquals(expectedFoeAmount, foeList.size());
        Assertions.assertEquals(ConcreteFoe.class, foeList.getFirst().getClass());
    }

    static class WaveTestListener implements WaveListener {
        int waveCounter = 0;
        @Override
        public void waveCounterChanged(int newWaveValue) {
            waveCounter = newWaveValue;
        }
    }
}

