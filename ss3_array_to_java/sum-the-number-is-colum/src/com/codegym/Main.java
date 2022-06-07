package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row;
        int colum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        row = scanner.nextInt();
        System.out.print("Enter colum: ");
        colum = scanner.nextInt();
        double array[][] = new double[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print("Array [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Array: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        int columX;
        do {
            System.out.print("\nEnter colum need sum: ");
            columX = scanner.nextInt();
            if (columX > colum) {
                System.out.print("Enter columX <= colum");
            }
        } while (columX > colum);

        double sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = columX; j <= columX; j++) {
                sum += array[i][j];
            }
        }
        System.out.println("Total of colum " + columX + " = " + sum);
    }
}
