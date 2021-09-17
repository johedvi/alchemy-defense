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

    private Map<Integer, ConcreteFoe> aliveFoes = new HashMap<>();

    public Wave(int boardHeight, PathFinder pathFinder) {
        spawnFoes(boardHeight, pathFinder);
    }

    public void startWave() { waveCounter++; }

    //Using a preliminary model to calculate how many foes should be created each round.
    public void spawnFoes(int boardHeight, PathFinder pathFinder) {
        int nFoes = (int) (FIRST_WAVE_FOE_AMOUNT * Math.pow(WAVE_DIFFICULTY_FACTOR, waveCounter));
        for(int i = 0; i <= nFoes; i++) {
            aliveFoes.put(i, new ConcreteFoe(boardHeight, pathFinder, i));
        }
    }

    public boolean isWaveOver() { return aliveFoes.isEmpty(); }

    public int getWaveCounter() { return waveCounter; }

}
