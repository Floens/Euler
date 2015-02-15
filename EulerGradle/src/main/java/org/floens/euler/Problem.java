package org.floens.euler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Problem {
    private static final Logger log = LogManager.getLogger("Problem");

    public abstract String solve();

    public void log(Object obj) {
        log.info(obj);
    }

    public void logA(Object[] objs) {
        log.info(objs);
    }

    public void log(String message, Object... args) {
        log.info(message, args);
    }
}
