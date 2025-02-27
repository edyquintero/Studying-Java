package com.platzi.javaTests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        if (times < 0)
            throw new IllegalArgumentException();
        return String.valueOf(str).repeat(Math.max(0, times));
    }
}
