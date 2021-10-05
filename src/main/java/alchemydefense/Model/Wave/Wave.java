package alchemydefense.Model.Wave;

import alchemydefense.Model.Foe.FoeFactory;
import alchemydefense.Model.Foe.Foe;

import java.util.*;

/**
 * @author Valdemar Stenhammar
 *
 * Class representing a wave that spawns foes.
 *
 * Date: 2021-09-16
 */

public class Wave {

    private static final int FIRST_WAVE_FOE_AMOUNT = 10;
    private static final double WAVE_DIFFICULTY_FACTOR = 1.1;

    private static int waveCounter = 0;

    /**
     * Constructor for wave, increments waveCounter when a wave is created.
     * */

    public Wave() {
        waveCounter++;
    }


    /**
     * Creates foes and adds to a linkedlist depending on what level you are on.
     * @return Linkedlist of foes.
     * */

    //TODO using a preliminary model to calculate how many foes should be created each round.
    public LinkedList<Foe> createFoes() {
        int nFoes = (int) (FIRST_WAVE_FOE_AMOUNT * Math.pow(WAVE_DIFFICULTY_FACTOR, (waveCounter-1)));
        LinkedList<Foe> foes = new LinkedList<>();
        for(int i = 0; i <= nFoes; i++) {
            foes.add(FoeFactory.createFoe(FoeFactory.FoeTypes.CONCRETE_FOE));
        }
        return foes;
    }

    public int getWaveCounter() { return waveCounter; }

}
