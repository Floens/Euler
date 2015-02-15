package org.floens.euler.problems;

import org.floens.euler.Problem;
import org.floens.euler.math.MathUtils;

public class Problem30 extends Problem {
    @Override
    public String solve() {
        final int size = 7;
        final int power = 5;

        final int max = MathUtils.longPow(9, power) * size;

        long totalSum = 0;
        int inc, i;
        long total;
        long[] digits = new long[size];
        for (long j = 2; j < max; j++) {
            for (i = 0; i < size; i++) {
                digits[size - i - 1] = (j / MathUtils.longPow(10, i)) % 10;
            }

            total = 0;
            for (i = 0; i < size; i++) {
                total += MathUtils.longPow(digits[i], power);
            }

            if (total == j) {
                log("Winner! " + j);
                totalSum += j;
            }
        }

        return "Total sum: " + totalSum;
    }
}
