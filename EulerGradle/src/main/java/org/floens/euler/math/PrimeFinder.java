package org.floens.euler.math;

public class PrimeFinder {
    private int max;
    private boolean[] primes;

    public PrimeFinder(int max) {
        this.max = max;
    }

    public void calculate() {
        primes = new boolean[max];
        for (int i = 0; i < max; i++) {
            primes[i] = isPrime(i);
        }
    }

    public boolean get(int prime) {
        return primes[prime];
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
