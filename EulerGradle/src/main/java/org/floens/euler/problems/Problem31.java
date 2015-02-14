package org.floens.euler.problems;

import org.floens.euler.Problem;

public class Problem31 extends Problem {
    @Override
    public String solve() {
        final int target = 200;
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

        int[] ways = new int[target + 1];
        ways[0] = 1;

        int i, j;
        for (i = 0; i < coins.length; i++) {
            for (j = coins[i]; j <= target; j++) {
                ways[j] += ways[j - coins[i]];
            }
        }

        return ways[target] + " ways";
    }
}
