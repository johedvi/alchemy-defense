package alchemydefense.Model.Wave;

import alchemydefense.Model.Foe.ConcreteFoe;
import alchemydefense.Model.Foe.Pathfinding.PathFinder;

import java.util.ArrayList;
import java.util.List;

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

    //TODO Should probably not be of type List. Map might be a better option to easily access each Foe.
    private List<ConcreteFoe> aliveFoes = new ArrayList<>();

    public Wave(int boardHeight, PathFinder pathFinder) {
        spawnFoes(boardHeight, pathFinder);
    }

    public void startWave() { waveCounter++; }

    //Using a preliminary model to calculate how many foes should be created each round.
    public void spawnFoes(int boardHeight, PathFinder pathFinder) {
        int nFoes = (int) (FIRST_WAVE_FOE_AMOUNT * Math.pow(WAVE_DIFFICULTY_FACTOR, waveCounter));
        for(int i = 0; i <= nFoes; i++) {
            aliveFoes.add(new ConcreteFoe(boardHeight, pathFinder));
        }
    }

    public boolean isWaveOver() { return aliveFoes.isEmpty(); }

    public int getWaveCounter() { return waveCounter; }

}
