package alchemydefense.Model.Foe;

import alchemydefense.Utility.BoardObjectType;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class representing a wave that spawns foes.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-09-16
 */

public class Wave {

    private static final ArrayList<WaveListener> listeners = new ArrayList<>();

    private static final int FIRST_WAVE_FOE_AMOUNT = 10;
    private static final double WAVE_DIFFICULTY_FACTOR = 1.1;

    private static int waveCounter = 0;

    /**
     * Constructor for wave, increments waveCounter when a wave is created.
     */
    public Wave() {
        waveCounter++;
        updateWaveListeners();
    }

    /**
     * Creates foes and adds to a linkedlist depending on what level you are on.
     * @return Linkedlist of foes.
     */
    public LinkedList<Foe> createFoes() {
        int nFoes = (int) (FIRST_WAVE_FOE_AMOUNT * Math.pow(WAVE_DIFFICULTY_FACTOR, waveCounter - 1));
        LinkedList<Foe> foes = new LinkedList<>();
        for(int i = 0; i <= nFoes; i++) {
            foes.add(FoeFactory.createFoe(BoardObjectType.CONCRETE_FOE));
        }
        return foes;
    }

    public static void addWaveListener(WaveListener listener) {
        listeners.add(listener);
        updateWaveListeners();
    }

    private static void updateWaveListeners() {
        for(WaveListener listener : listeners) {
            listener.waveCounterChanged(waveCounter);
        }
    }

}
