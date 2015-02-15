package org.floens.euler.problems;

import org.floens.euler.Problem;

public class Problem34 extends Problem {
    long[] factorials = new long[10];

    @Override
    public String solve() {
        for (int i = 0; i <= 9; i++) {
            long num = 1;
            long index = i;
            while (index > 1) {
                num *= index;
                index--;
            }
            factorials[i] = num;
        }

        int[] test = new int[8];
        int j, k;
        long sum;
        boolean a;
        long totalSum = 0;
        outer: for (long i = 1;; i++) {
            j = test.length - 1;
            while (true) {
                if (j == 0) {
                    break outer;
                }

                if (test[j] == 9) {
                    test[j] = 0;
                    j--;
                } else {
                    test[j]++;
                    break;
                }
            }

            sum = 0;
            a = true;
            for (k = 0; k < test.length; k++) {
                if (a && test[k] == 0) {
                    continue;
                } else {
                    a = false;
                }
                sum += factorials[test[k]];
            }

            if (sum == i) {
                if (sum > 2) {
                    log(sum);
                    totalSum += sum;
                }
            }
        }

        return String.valueOf(totalSum);
    }
}
