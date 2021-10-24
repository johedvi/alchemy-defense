package alchemydefense.Controller;

import alchemydefense.Model.IWaveHandler;

/**
 * Controller used for starting a new wave
 *
 * @author Willem Brahmstaedt
 */
public class WaveController implements IWaveController {
    private final IWaveHandler waveHandler;

    public WaveController(IWaveHandler waveHandler) { this.waveHandler = waveHandler; }

    /**
     * Delegates the request of a new wave to the IWaveHandler
     */
    @Override
    public void startNewWave() { waveHandler.startNewWave(); }
}
