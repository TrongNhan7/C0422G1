package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number;
        int i = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number prime you want search: ");
        number = input.nextInt();
        while (i < number) {
            if (isPrimeNumber(i)) {
                System.out.println(i + " ");
            }
            i++;
        }
    }

    public static boolean isPrimeNumber(int N) {
        if (N < 2) {
            return false;
        } else {
            for (int i = 2; i <= (int) Math.sqrt(N); i++) {
                if (N % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
