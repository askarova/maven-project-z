package com.cybertek.utilities;

public class SingletonClassExample {
    private static String str;

    public static String getTheString() {
        if (str == null) {
            System.out.println("adding value");
            str = "something";
        }

        return str;
    }
}
