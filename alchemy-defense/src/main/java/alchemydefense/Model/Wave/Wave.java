package alchemydefense.Model.Wave;

import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.PathFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Wave() {
        waveCounter++;
    }

    //TODO using a preliminary model to calculate how many foes should be created each round.
    public List<ConcreteFoe> createFoes(int boardHeight, PathFinder pathFinder) {
        int nFoes = (int) (FIRST_WAVE_FOE_AMOUNT * Math.pow(WAVE_DIFFICULTY_FACTOR, (waveCounter-1)));
        List<ConcreteFoe> foes = new ArrayList<>();
        for(int i = 0; i <= nFoes; i++) {
            foes.add(new ConcreteFoe(boardHeight, pathFinder, i));
        }
        return foes;
    }

    public int getWaveCounter() { return waveCounter; }

}
