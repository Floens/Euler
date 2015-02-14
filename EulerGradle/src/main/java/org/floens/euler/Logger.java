package org.floens.euler;

import java.util.Arrays;

public class Logger {
    public static void log(Object obj) {
        System.out.println(obj.toString());
    }

    public static void logA(Object[] objs) {
        System.out.println(Arrays.toString(objs));
    }
}
