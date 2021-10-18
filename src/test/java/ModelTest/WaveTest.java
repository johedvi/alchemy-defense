package ModelTest;

import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Wave.Wave;
import alchemydefense.Model.Wave.WaveListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

        Assertions.assertEquals(12, foeList.size());
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

