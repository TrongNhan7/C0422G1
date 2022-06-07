package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] array;
        int row;
        int colum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        row = scanner.nextInt();
        System.out.print("Enter colum: ");
        colum = scanner.nextInt();
        array = new int[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print("Enter array[" + i + "] [" + j + "]=");
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("\n");
        }
        int max = array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Element max: " + max);
    }
}
