package org.floens.euler;

public abstract class Problem {
    public abstract String solve();

    public void log(Object obj) {
        Logger.log(obj);
    }

    public void logA(Object[] objs) {
        Logger.logA(objs);
    }
}
