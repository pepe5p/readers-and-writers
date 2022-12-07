package com.pkaras;

import java.io.PrintStream;

public class Console {
    @SuppressWarnings("java:S106")
    static final PrintStream out = System.out;
    static final String RESET_COLOR = "\u001B[0m";

    Console() {}

    static void print(String color, String message) {
        out.format("%s%s%s%n", color, message, RESET_COLOR);
    }
}
