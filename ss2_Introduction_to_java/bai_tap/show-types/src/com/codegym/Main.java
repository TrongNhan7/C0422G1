package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 5) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square botton-left triangle");
            System.out.println("3. Print the square top-left triangle");
            System.out.println("4. Print isosceles triangle");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    String result = "";
                    System.out.println("Input height");
                    int height = input.nextInt();
                    System.out.println("Input width");
                    int width = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        result += "\n";
                        for (int j = 0; j < width; j++) {
                            result += "*";
                        }
                    }
                    System.out.println(result);
                    break;
                case 2:
                    String result2 = "";
                    System.out.println("Input x");
                    int x = input.nextInt();
                    for (int i = 1; i <= x; i++) {
                        result2 += "\n";
                        for (int j = 1; j <= i; j++) {
                            result2 += "*";
                        }
                    }
                    System.out.println(result2);
                    break;
                case 3:
                    String result3 = "";
                    System.out.println("Input y");
                    int y = input.nextInt();
                    for (int i = 1; i <= y; i++) {
                        result3 += "\n";
                        for (int j = 1; j <= y - (i - 1); j++) {
                            result3 += "*";
                        }
                    }
                    System.out.println(result3);
                    break;
                case 4:
                    String result4 = "";
                    System.out.println("Input z");
                    int z = input.nextInt();
                    int i = 1;
                    while (i <= z) {
                        for (int j = 1; j <= (z - i); j++) {
                            result4 += " ";
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            result4 += "*";
                        }
                        result4 += "\n";
                        i++;
                    }
                    System.out.println(result4);
            }
        }
    }
}
