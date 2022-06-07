package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan fan1 = new Fan(10, true, 10, "yellow");
        Fan fan2 = new Fan(5, false, 5, "blue");
        fan1.toStringFan();
        fan2.toStringFan();
    }
}
