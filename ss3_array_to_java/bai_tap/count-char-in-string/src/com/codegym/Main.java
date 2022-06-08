package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Enter string: ");
        str = scanner.nextLine();
        System.out.println("Str : " + str);
        char x;
        System.out.print("Enter x: ");
        x = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == x) {
                count++;
            }
        }
        System.out.println("Repeating char =  " + count);
    }
}
