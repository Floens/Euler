package org.floens.euler.math;

public class MathUtils {
    public static int pow(long base, long exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exp <= 0");
        }

        int result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                result *= base;
            }
            exp >>= 1;
            base *= base;
        }

        return result;
    }
}
