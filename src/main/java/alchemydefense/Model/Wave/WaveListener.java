package alchemydefense.Model.Wave;

/**
 * Interface to notify when a new wave is started.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-10-12
 */
public interface WaveListener {

    /**
     * Notifies all WaveListeners that the wave counter has been updated.
     * @param newWaveValue the new value of waveCounter.
     */
    void waveCounterChanged(int newWaveValue);
}
