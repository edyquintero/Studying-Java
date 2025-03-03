package com.platzi.javaTests.util;

public class StringUtil {

    enum Strings{
        NULL, ZERO_LENGTH, EMPTY_STRING, STRING_ONLY_SPACES, NOT_NULL
    }

    private Strings statusString;

    public static String repeat(String str, int times) {
        if (times < 0)
            throw new IllegalArgumentException();
        return String.valueOf(str).repeat(Math.max(0, times));
    }

    public static Strings getStatusString(String str) {
        if (str == null) return Strings.NULL;
        if (str.isEmpty()) return Strings.ZERO_LENGTH;
        if (str.trim().isEmpty()) return Strings.STRING_ONLY_SPACES;
        return Strings.NOT_NULL;
    }

    public Strings getStatusString() {
        return statusString;
    }
}
