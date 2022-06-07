package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array: ");
        size = scanner.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Array: ");
        for (int element : array) {
            System.out.print(element + "\t");
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("\nElement min: " + min);
    }
}
