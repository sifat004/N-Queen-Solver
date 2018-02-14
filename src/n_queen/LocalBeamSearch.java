/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_queen;

/**
 *
 * @author Sifat Ullah
 */

import java.util.Arrays;
import java.util.Comparator;



public class LocalBeamSearch {


    public int[] solve(int n, int maxNumOfIterations, int numOfStates) {
        int[][] states = new int[numOfStates][];

        for (int i = 0; i < numOfStates; i++)
            states[i] = SolverUtils.generateRandomState(n);


        for (int x = 0; x < maxNumOfIterations; x++) {

            int[][] newStates = new int[n*numOfStates][];
            for (int i = 0; i < numOfStates; i++) {
                int costToBeat = SolverUtils.getHeuristicCost(states[i]);

                // if solved
                if (costToBeat == 0)
                    return states[i];

                for (int col = 0; col < n; col++) {
                    newStates[i*n + col] = makeMove(states[i], col, costToBeat);

                    // if stuck
                    if (newStates[i*n + col] == null)
                        newStates[i*n + col] = SolverUtils.generateRandomState(n);
                }

            }
            Arrays.sort(newStates, Comparator.comparingInt(SolverUtils::getHeuristicCost));

            states = Arrays.copyOfRange(newStates, 0, numOfStates);

        }

        return null;
    }

    private int[] makeMove(int r[], int col, int costToBeat) {
        int n = r.length;

        for (int row = 0; row < n; row++) {
            // we do not need to evaluate because we already know current cost by costToBeat.
            if (row == r[col])
                continue;

            int tmpRow = r[col];
            r[col] = row;
            int cost = SolverUtils.getHeuristicCost(r);
            if (costToBeat > cost) {
                r[col] = row;
                return r;
            }
            r[col] = tmpRow;
        }

        return null;
    }


}