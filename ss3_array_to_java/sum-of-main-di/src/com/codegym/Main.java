package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        x = scanner.nextInt();
        double array[][] = new double[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("Array [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Array: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        double sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if(i==j){
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Total of main diagonals = " + sum);
    }
}
