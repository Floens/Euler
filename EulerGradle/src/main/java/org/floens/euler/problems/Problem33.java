package org.floens.euler.problems;

import org.floens.euler.Problem;
import org.floens.euler.math.MathUtils;

public class Problem33 extends Problem {
    @Override
    public String solve() {
        int a1, a2, b1, b2;

        int totalNum = -1, totalDen = -1;

        for (a1 = 11; a1 <= 99; a1++) {
            for (a2 = a1; a2 <= 99; a2++) {
                for (b1 = 1; b1 <= 9; b1++) {
                    for (b2 = b1 + 1; b2 <= 9; b2++) {
                        if (a1 * b2 - a2 * b1 == 0) {
                            if (digit(a1, 0) == 0 || digit(a2, 0) == 0) {
                                continue;
                            }

                            int num = -1;
                            int den = -1;
                            if (digit(a1, 0) == digit(a2, 0) && digit(a1, 1) == b1 && digit(a2, 1) == b2) {
                                num = a1;
                                den = a2;
                            }
                            if (digit(a1, 1) == digit(a2, 1) && digit(a1, 0) == b1 && digit(a2, 0) == b2) {
                                num = a1;
                                den = a2;
                            }
                            if (digit(a1, 1) == digit(a2, 0) && digit(a1, 0) == b1 && digit(a2, 1) == b2) {
                                num = a1;
                                den = a2;
                            }
                            if (digit(a1, 0) == digit(a2, 1) && digit(a1, 1) == b1 && digit(a2, 0) == b2) {
                                num = a1;
                                den = a2;
                            }

                            if (num > 0) {
                                if (totalNum < 0) {
                                    totalNum = num;
                                    totalDen = den;
                                } else {
                                    totalNum *= num;
                                    totalDen *= den;
                                }

                                log("{}/{} == {}/{}", a1, a2, b1, b2);
                            }
                        }
                    }
                }
            }
        }

        log("{} {}", totalNum, totalDen);

        return String.valueOf((int) (1.0 / (totalNum / (double) totalDen)));
    }

    private int digit(int num, int index) {
        return (num / MathUtils.longPow(10, index)) % 10;
    }
}
