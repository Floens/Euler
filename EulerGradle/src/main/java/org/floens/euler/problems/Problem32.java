package org.floens.euler.problems;

import java.util.HashSet;
import java.util.Set;

import org.floens.euler.Problem;
import org.floens.euler.math.MathUtils;

public class Problem32 extends Problem {
    @Override
    public String solve() {
        long total = 0;
        long a, b, c;
        Set<Long> seenOutcomes = new HashSet<>();
        for (a = 1; a <= 2000; a++) {
            for (b = a; b <= 2000; b++) {
                c = a * b;

                int digits = ((int) Math.log10(a) + 1) + ((int) Math.log10(b) + 1) + ((int) Math.log10(c) + 1);
                if (digits != 9) {
                    continue;
                }
                boolean[] seen = new boolean[digits];

                if (!fill(a, seen)) {
                    continue;
                }
                if (!fill(b, seen)) {
                    continue;
                }
                if (!fill(c, seen)) {
                    continue;
                }

                for (int i = 0; i < seen.length; i++) {
                    if (!seen[i])
                        continue;
                }

                if (seenOutcomes.contains(c)) {
                    log("{} {} {} already exists", a, b, c);
                    continue;
                }
                seenOutcomes.add(c);

                log("Adding {} {} {}", a, b, c);

                total += c;
            }
        }

        return "sum " + total;
    }

    private boolean fill(long num, boolean[] seen) {
        int digits = (int) Math.log10(num) + 1;
        for (int i = 0; i < digits; i++) {
            int a = (int) ((num / MathUtils.longPow(10, digits - i - 1)) % 10);

            if (a <= 0 || a > seen.length || seen[a - 1]) {
                return false;
            } else {
                seen[a - 1] = true;
            }
        }

        return true;
    }
}
